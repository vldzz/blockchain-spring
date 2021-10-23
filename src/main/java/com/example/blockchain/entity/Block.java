package com.example.blockchain.entity;

import com.example.blockchain.util.Sha256;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Block {
    @Id
    private long id;
    private long timestamp;
    private long generatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id")
    @NotNull
    private Wallet wallet;

    private String prevHash;

    @Transient
    private String hash;
    private int magicNum = 0;

    public Block() {
        this.timestamp = new Date().getTime();
    }

    @Column(name = "hash")
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
