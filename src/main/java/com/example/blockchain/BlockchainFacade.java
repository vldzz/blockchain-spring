package com.example.blockchain;

import com.example.blockchain.config.Configs;
import com.example.blockchain.entity.Blockchain;
import com.example.blockchain.entity.Wallet;
import com.example.blockchain.logger.Log;
import com.example.blockchain.persistence.service.BlockService;
import com.example.blockchain.persistence.service.WalletService;
import com.example.blockchain.workers.Miner;

import java.util.stream.IntStream;

public class BlockchainFacade {
    private static Blockchain blockchain = Blockchain.getInstance();
    private static int walletIndex = 0;
    private static int maxBlocksToMine = 2;

    public static void testRun(BlockService blockService, WalletService walletService) {
        Configs.LOG = Log.INFO;
        blockchain.setBlockService(blockService);

        Blockchain blockchain = Blockchain.getInstance();
        blockchain.setBlockService(blockService);

        IntStream.range(0, 2)
                .mapToObj(Miner::new).forEach((miner -> {
                    miner.setBlockchain(blockchain);

                    Wallet wallet = Wallet.generateWallet(walletService);
                    walletService.save(wallet);

                    miner.setWallet(wallet);
                    new Thread(miner).start();
                }));
    }

    public static void stop() {
        Configs.MINE = false;
    }
}
