package com.example.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

    public static void main(String[] args)   {
        BlockchainFacade.testRun();
        SpringApplication.run(BlockchainApplication.class, args);
    }

}
