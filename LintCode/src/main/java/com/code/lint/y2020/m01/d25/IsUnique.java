package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 21:58
 */

public class IsUnique {

    /**
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        for (int i = 1;i<str.length();i++){
            if(str.indexOf(str.charAt(i))!=str.lastIndexOf(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
