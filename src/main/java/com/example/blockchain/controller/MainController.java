package com.example.blockchain.controller;

import com.example.blockchain.BlockchainFacade;
import com.example.blockchain.entity.Block;
import com.example.blockchain.entity.Wallet;
import com.example.blockchain.logger.Logger;
import com.example.blockchain.persistence.service.BlockService;
import com.example.blockchain.persistence.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    BlockService blockService;

    @Autowired
    WalletService walletService;

    @GetMapping("/")
    public String hellow() {
        return "Hellow";
    }

    @GetMapping("/start")
    public void start() {
//        Block block = new Block();
//        Wallet wallet = Wallet.generateWallet();
//        block.setWallet(wallet);
//
//        walletService.save(wallet);
//        blockService.save(block);
//
//        Logger.log("agent saved");
//        return blockService.count() + " ";
        BlockchainFacade.testRun(blockService, walletService);
    }

    @GetMapping("/stop")
    public void stop() {
        BlockchainFacade.stop();
    }
}
