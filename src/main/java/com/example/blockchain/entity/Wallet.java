package com.example.blockchain.entity;

import com.example.blockchain.util.Sha256;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@AllArgsConstructor
public class Wallet {
    private UUID id;

    @Getter
    private Agent agent;

    @Getter
    private String hash;

    @Getter
    @Setter
    private double amount = 0;

    private Wallet(){}

    public static Wallet generateWallet(Agent agent) {
        Wallet wallet = new Wallet();
        wallet.id = UUID.randomUUID();
        wallet.agent = agent;
        wallet.hash = Sha256.applySha256(wallet.toString());

        return wallet;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", agent=" + agent.toString();
    }
}
