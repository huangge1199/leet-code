package com.code.lint.y2020.m01.d25;

import java.util.regex.Pattern;

/**
 * @Author: hyy
 * @Date: 2020-01-25 19:50
 */

public class Solution {

    /**
     * @param s: the article
     * @return: the number of letters that are illegal
     */
    public int count(String s) {
        // Write your code here.
        int num = 0;
        String[] sentence = s.split("\\.");
        for (String str:sentence) {
            if(!Pattern.matches("^[A-Z].*",str.trim())){
                num++;
            }
            String[] words = str.split(" |,");
            for(String word:words){
                for (int i=1;i<word.length();i++){
                    if(Pattern.matches("[A-Z]",""+word.charAt(i))){
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
