package com.example.blockchain.persistence;

import com.example.blockchain.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionTempStorage {
    private List<Transaction> transactionList;
    private static TransactionTempStorage instance;


    private TransactionTempStorage() {
        transactionList = new ArrayList<>();
    }

    public static TransactionTempStorage getInstance() {
        if (instance == null) instance = new TransactionTempStorage();
        return instance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
