package com.example.blockchain;

import com.example.blockchain.config.Configs;
import com.example.blockchain.entity.Agent;
import com.example.blockchain.entity.Blockchain;
import com.example.blockchain.logger.Log;
import com.example.blockchain.workers.Miner;

import java.util.stream.IntStream;

public class BlockchainFacade {
    private static Blockchain blockchain = Blockchain.getInstance();
    private static int walletIndex = 0;
    private static int maxBlocksToMine = 2;

    public static void testRun() {
        Configs.LOG = Log.INFO;


        Agent agent = new Agent();
        agent.setBlockchain(blockchain);
        agent.generateWallet();

        IntStream.rangeClosed(0, 2).limit(maxBlocksToMine)
                .mapToObj(Miner::new).forEach((miner -> {
            miner.setBlockchain(blockchain);
            miner.setWallet(agent.getWalletList().get(walletIndex));
            miner.run();
        }));


    }
}
