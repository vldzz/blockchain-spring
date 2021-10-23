package com.example.blockchain.entity;

import com.example.blockchain.persistence.service.WalletService;
import com.example.blockchain.util.Sha256;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    private UUID id;

    @Getter
    private String hash;

    @Getter
    private double amount = 0;

    @Transient
    private static WalletService walletService;

    @OneToMany(targetEntity = Block.class, mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Block> blocks = new ArrayList<>();

    protected Wallet() {

    }

    public static Wallet generateWallet(WalletService walletService) {
        Wallet wallet = new Wallet();
        wallet.id = UUID.randomUUID();
        wallet.hash = Sha256.applySha256(wallet.toString());
        Wallet.walletService = walletService;


        return wallet;
    }


    public void setAmount(double amount) {
        this.amount = amount;
        walletService.save(this);
    }


}
