package com.code.war.entry;

/**
 * @Author: hyy
 * @Date: 2020-04-24 15:53
 */

public class Token {

    private String text;
    private String type;

    public Token(String text, String type) {
        this.text = text;
        this.type = type;
        System.out.println("text=" + text + ",type=" + type);
    }
}
