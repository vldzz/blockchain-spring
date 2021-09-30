package com.example.blockchain.entity;

import com.example.blockchain.util.Sha256;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Block {
    private long id;
    private long timestamp;
    private Wallet wallet;
    private String prevHash;
    private String hash;
    private int magicNum = 0;

    public Block() {
        this.timestamp = new Date().getTime();
    }

    public String getHash() {
        return Sha256.applySha256(this.toString());
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", timestamp=" + timestamp +
                ", prevHash='" + prevHash + '\'' +
                ", wallet=" + wallet +
                ", magicNum=" + magicNum;
    }
}
