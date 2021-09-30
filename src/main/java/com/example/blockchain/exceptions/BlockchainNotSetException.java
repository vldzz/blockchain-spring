package com.example.blockchain.exceptions;

public class BlockchainNotSetException extends Throwable {
    public BlockchainNotSetException() {
    }

    public BlockchainNotSetException(String message) {
        super(message);
    }
}
