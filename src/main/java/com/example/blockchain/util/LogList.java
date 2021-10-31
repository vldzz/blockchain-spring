package com.example.blockchain.util;

import com.example.blockchain.entity.Block;
import com.example.blockchain.logger.Colors;
import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
public class LogList {
    private static LogList instance;
    private final List<String> list = new ArrayList<>();

    private LogList() {}

    public static LogList getInstance() {
        if (instance == null)
            instance = new LogList();
        return instance;
    }

    private void add(String str) {
        if (list.size() > 200)
            list.remove(0);
        list.add(str);

    }

    public void log(String str) {
        String res = "" +
                "<span class=\"" + Colors.HTML_Colors.RED + "\">" + fillString(Thread.currentThread().getName(), 10) + "</span> |   " +
                "<span class=\"" + Colors.HTML_Colors.CYAN + "\">" + getTime() + "</span>" + str +
                "<br>";

        add(res);
    }

    public void log(Block block, String message) {
        String res = "" +
                "<span class=\"" + Colors.HTML_Colors.CYAN + "\">" + fillString(Thread.currentThread().getName(), 10) + "</span> |   " +
                "<span class=\"" + Colors.HTML_Colors.YELLOW + "\">" + fillString(getTime(), 20) + "</span> |   " +
                "<span class=\"" + Colors.HTML_Colors.BLUE + "\">" + fillString(message, 20) + "</span> |   " +
                "<span class=\"" + Colors.HTML_Colors.GREEN + "\">id:" + block.getId() + "</span>, " +
                "<span class=\"" + Colors.HTML_Colors.YELLOW + "\">timestamp:" + block.getTimestamp() + "</span>, " +
                "<span class=\"" + Colors.HTML_Colors.CYAN + "\">prev hash:" + block.getPrevHash() + "</span>, " +
                "<span class=\"" + Colors.HTML_Colors.CYAN + "\">hash:" + block.getHash() + "</span>, " +
                "<span class=\"" + Colors.HTML_Colors.RED + "\">amount:" + block.getWallet().getAmount() + "</span>, " +
                "<br>";

        add(res);
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
