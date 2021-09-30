package com.example.blockchain.entity;

import com.example.blockchain.config.Configs;
import com.example.blockchain.logger.Log;
import com.example.blockchain.logger.Logger;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Agent {
    private long id = getLastId();
    private List<Wallet> walletList = new ArrayList<>();

    @Setter
    private Blockchain blockchain;


    public void generateWallet() {
        Wallet wallet = Wallet.generateWallet(this);
        walletList.add(wallet);

        if (Configs.LOG != Log.NONE)
            Logger.log("Created wallet: " + wallet.toString());
    }

    public static long getLastId() {
        //TODO: Search in all network for last id
        return 0;
    }

}
