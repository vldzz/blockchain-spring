package com.example.blockchain.persistence.service;

import com.example.blockchain.entity.Block;
import com.example.blockchain.persistence.repository.BlockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlockService {
    BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public long count() {
        return blockRepository.count();
    }

    public Optional<Block> findById(long lastId) {
        return blockRepository.findById(lastId);
    }

    public void save(Block block) {
        blockRepository.save(block);
    }
}
