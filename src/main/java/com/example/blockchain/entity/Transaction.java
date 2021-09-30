package com.example.blockchain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transaction {
    private Wallet from;
    private Wallet to;
    private double amount;
    private long timestamp;

    public Transaction(Wallet from, Wallet to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.timestamp = new Date().getTime();
    }
}
