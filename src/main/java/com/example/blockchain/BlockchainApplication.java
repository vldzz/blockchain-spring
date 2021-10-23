package com.example.blockchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.blockchain.persistence.repository")
public class BlockchainApplication {

    public static void main(String[] args)   {
        SpringApplication.run(BlockchainApplication.class, args);
    }

}
