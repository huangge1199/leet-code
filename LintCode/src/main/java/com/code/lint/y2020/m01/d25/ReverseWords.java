package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 21:57
 */

public class ReverseWords {
    /**
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if(s.equals("")) {
            return s;
        }
        String[] strings = s.split(" ");
        s = "";
        for (String str:strings
        ) {
            if(!str.equals("")){
                s = str + " " + s;
            }
        }
        if(!s.equals("")){
            s = s.substring(0,s.length()-1);
        }
        return s;
    }
}
