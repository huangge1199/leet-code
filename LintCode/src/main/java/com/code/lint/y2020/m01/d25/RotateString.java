package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 18:51
 */

public class RotateString {
    public static void main(String[] args) {
        String str="abcdefg";
        int offset = 3;
        rotateString(str.toCharArray(),offset);
    }
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        if(str.length == 0 || offset == 0){
            return;
        }
        offset = offset%str.length;//实际偏移量
        for(int i = 0;i<offset; i++){
            char temp = str[str.length-1];
            for(int j = str.length-1;j>0;j--){
                str[j] = str[j-1];
            }
            str[0] = temp;
        }
    }
}
