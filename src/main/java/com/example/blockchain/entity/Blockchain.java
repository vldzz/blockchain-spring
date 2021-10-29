package com.example.blockchain.entity;

import com.example.blockchain.persistence.service.BlockService;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class Blockchain {
    private static Blockchain instance;
    @Getter
    @Setter
    private BlockService blockService;


    //TODO: Regulate it
    @Getter
    private int numOfZero = 4;

    private Blockchain() {
//        blocks = new ArrayList<>();
    }

    public static Blockchain getInstance() {
        if (instance == null) instance = new Blockchain();
        return instance;
    }

    public boolean addBlock(Block block) {
        blockService.save(block);
        return true;
    }

    public long getLastId() {
        //TODO: Search in all network for last id
//        return blocks.size();
        return blockService.count();
    }


    public Optional<Block> getLastBlock() {
//        if (blocks.size() == 0) {
//            return Optional.empty();
//        }
//        return Optional.of(blocks.get(blocks.size() - 1));
        return blockService.findLast();
    }


}
