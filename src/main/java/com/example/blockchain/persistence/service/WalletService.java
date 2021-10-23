package com.example.blockchain.persistence.service;

import com.example.blockchain.entity.Block;
import com.example.blockchain.entity.Wallet;
import com.example.blockchain.persistence.repository.BlockRepository;
import com.example.blockchain.persistence.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {
    WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public long count() {
        return walletRepository.count();
    }

    public Optional<Wallet> findById(UUID uuid) {
        return walletRepository.findById(uuid);
    }

    public void save(Wallet wallet) {
        walletRepository.save(wallet);
    }
}
