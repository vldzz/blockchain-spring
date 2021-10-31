package com.example.blockchain.logger;

import com.example.blockchain.entity.Block;
import com.example.blockchain.util.LogList;

import java.time.LocalTime;

public class Logger {
    public static void log(Block block) {
        log(block, "");
    }

    public static void log(Block block, String message) {
        LogList.getInstance().log(block, message);
        System.out.println(
                threadColor(Thread.currentThread().getName()) +
                "LOG: " +
                        Colors.Regular_Colors.CYAN +
                        fillString(Thread.currentThread().getName(), 10) +
                        Colors.Regular_Colors.RED + "|   " +

                        Colors.Regular_Colors.YELLOW +
                        fillString(getTime(), 20) +
                        Colors.Regular_Colors.RED + "|   " +

                        Colors.Regular_Colors.BLUE + message +

                        Colors.Regular_Colors.GREEN +
                        "id:" + block.getId() + ", " +

                        Colors.Regular_Colors.PURPLE +
                        "timestamp:" + block.getTimestamp() + ", " +

                        Colors.Regular_Colors.CYAN +
                        "prevHash:" +block.getPrevHash() + ", " +

                        Colors.Regular_Colors.CYAN +
                        "hash:" +block.getHash() + ", " +

                        Colors.Regular_Colors.YELLOW +
                        "wallet:" + block.getWallet().getHash() + ", " +

                        Colors.Regular_Colors.RED +
                        "amount:" + block.getWallet().getAmount() +
                        Colors.RESET);
    }


    public static void log(String e) {
        LogList.getInstance().log(e);
        System.out.println(
                Colors.Regular_Colors.RED + "LOG: " +
                        fillString(Thread.currentThread().getName(), 10) + "|   " +
                        fillString(getTime(), 20) + "|   " +
                        e + Colors.RESET);
    }


    private static String threadColor(String threadName) {
        String num = threadName.split("-")[1];
        int i = Integer.parseInt(num);
        if (i % 2 == 0)
            return Colors.Background.BLACK_BACKGROUND;
        return Colors.Background.WHITE_BACKGROUND;
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
