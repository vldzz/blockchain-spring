package com.example.blockchain.workers;

import com.example.blockchain.config.Configs;
import com.example.blockchain.entity.Block;
import com.example.blockchain.entity.Blockchain;
import com.example.blockchain.entity.Wallet;
import com.example.blockchain.exceptions.BlockchainNotSetException;
import com.example.blockchain.exceptions.WalletNotSetException;
import com.example.blockchain.logger.Log;
import com.example.blockchain.logger.Logger;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Setter
@Getter
public class Miner implements Runnable {
    private int id;
    private Wallet wallet;
    private Blockchain blockchain;
    private String numOfZeroRegex;

    public Miner(int id) {
        this.id = id;
        Thread.currentThread().setName("thread-" + id);
    }

    @Override
    public void run() {
        try {
            while (Configs.MINE) {
                Block next = mineBlock(generateNextBlock());

                if (Configs.LOG == Log.INFO) {
                    Logger.log(next, "Validated: ");
                }

                blockchain.addBlock(next);
            }
        } catch (WalletNotSetException | BlockchainNotSetException | Exception e) {
            e.printStackTrace();
        }
    }

    //Proof of concept
    private Block mineBlock(Block block) {
        Random random = new Random();

        if (Configs.LOG == Log.INFO) {
            Logger.log(block, "Validating:");
        }

        while (!isValid(block)) {
            block.setMagicNum(random.nextInt());

            if (Configs.LOG == Log.MORE_INFO) {
                Logger.log(isValid(block) + "-" + block.getMagicNum() + " - " + block.getHash());
            }

            Optional<Block> lastBlock = blockchain.getLastBlock();
            if (lastBlock.isPresent())
                if (lastBlock.get().getId() == block.getId()) {
                    block.setId(lastBlock.get().getId() + 1);
                }
        }

        wallet.setAmount(wallet.getAmount() + 100);
        block.setGeneratedTime(new Date().getTime());
        return block;
    }

    private boolean isValid(Block block) {
        return block.getHash().matches(numOfZeroRegex);
    }

    private synchronized Block generateNextBlock() throws WalletNotSetException, BlockchainNotSetException, Exception {
        if (wallet == null) {
            throw new WalletNotSetException();
        }
        if (blockchain == null) {
            throw new BlockchainNotSetException();
        }


        Block block = new Block();
        block.setId(blockchain.getLastId());
        block.setWallet(wallet);

        blockchain.getLastBlock().ifPresentOrElse(
                (b) -> block.setPrevHash(b.getHash()),
                () -> {
                    block.setPrevHash(Configs.emptyHash);
                }
        );


        return block;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
        numOfZeroRegex = "^0{" + blockchain.getNumOfZero() + ",}.*";

        if (Configs.LOG == Log.INFO || Configs.LOG == Log.MORE_INFO) {
            Logger.log(numOfZeroRegex);
        }
    }
}
