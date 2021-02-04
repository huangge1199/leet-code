package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 21:58
 */

public class FirstUniqChar {

    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        String temp;
        for (int i = 0; i < str.length(); i++){
            if(str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i))){
                return str.charAt(i);
            }
        }
        return '0';
    }
}
