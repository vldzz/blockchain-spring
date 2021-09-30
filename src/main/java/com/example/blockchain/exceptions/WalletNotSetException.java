package com.example.blockchain.exceptions;

public class WalletNotSetException extends Throwable{
    public WalletNotSetException(String message) {
        super(message);
    }

    public WalletNotSetException() {
    }
}
