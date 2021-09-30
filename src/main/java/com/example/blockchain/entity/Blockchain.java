package com.example.blockchain.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Blockchain {
    private static Blockchain instance;
    private List<Block> blocks;

    //TODO: Regulate it
    @Getter
    private int numOfZero = 3;

    private Blockchain() {
        blocks = new ArrayList<>();
    }

    public static Blockchain getInstance() {
        if (instance == null) instance = new Blockchain();
        return instance;
    }

    public boolean addBlock(Block block) {
        blocks.add(block);
        return true;
    }

    public long getLastId() {
        //TODO: Search in all network for last id
        return blocks.size();
    }


    public Optional<Block> getLastBlock() {
        if (blocks.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(blocks.get(blocks.size() - 1));
    }
}
