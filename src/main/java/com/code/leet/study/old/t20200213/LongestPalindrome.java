package com.code.leet.study.old.t20200213;

/**
 * @Author: hyy
 * @Date: 2020-02-13 10:14
 */

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = "";
        if (s.length() < 2) {
            result = s;
        } else {
            String str = new StringBuilder(s).reverse().toString();
            int start = 0;
            int length = 1;
            result = str.substring(start, 1);
            String temp = str;
            for (int i = 1; i < s.length(); i++) {
                int index = temp.indexOf(s.substring(i, i + 1));
                while (index >= 0) {
                    int j = 1;
                    while (i + j < s.length() && index + j < temp.length()) {
                        if (s.substring(i, i + j).equals(temp.substring(index, index + j))) {
                            j++;
                            if(i+index+j==s.length()&&j>length){
                                length=j;
                                result=s.substring(i,i+ j);
                            }
                        }else{
                            break;
                        }
                    }
                    index = temp.substring(index+1).indexOf(s.substring(i, i + 1));
                }
            }
        }
        return result;
    }
}
