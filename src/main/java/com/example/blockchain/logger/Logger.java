package com.example.blockchain.logger;

import com.example.blockchain.entity.Block;

import java.time.LocalTime;

public class Logger {
    public static void logBlock(Block block) {
        System.out.println(
                Colors.Regular_Colors.RED + "LOG: " +
                        fillString(Thread.currentThread().getName(), 10) + "|   " +
                        fillString(getTime(), 20) + "|   " +

                        Colors.Regular_Colors.GREEN +
                        "id:" + block.getId() + ", " +

                        Colors.Regular_Colors.PURPLE +
                        "timestamp:" + block.getTimestamp() + ", " +

                        Colors.Regular_Colors.CYAN +
                        "prevHash:" +block.getPrevHash() + ", " +

                        Colors.Regular_Colors.CYAN +
                        "hash:" +block.getHash() + ", " +

                        Colors.Regular_Colors.YELLOW +
                        "wallet:" + block.getWallet() + ", " +

                        Colors.Regular_Colors.WHITE +
                        "agent:" + block.getWallet().getAgent() +
                        Colors.RESET);
    }


    public static void log(String e) {
        System.out.println(
                Colors.Regular_Colors.RED + "LOG: " +
                        fillString(Thread.currentThread().getName(), 10) + "|   " +
                        fillString(getTime(), 20) + "|   " +
                        e + Colors.RESET);
    }


    private static String fillString(String str, int length) {
        if (str.length() >= length) return str;
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length() < length) {
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    private static String getTime() {
        return LocalTime.now().toString();
    }
}
