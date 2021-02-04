package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 22:06
 */

public class LengthOfLongestSubstring {
    /**
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s.length() < 2) {
            return s.length();
        }
        int count = 1;
        int num = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            int index = s.substring(start, i).indexOf(s.substring(i, i + 1));
            if (index == -1) {
                num++;
            } else {
                if (num > count) {
                    count = num;
                }
                start += index + 1;
                num = num - index;
            }
        }
        if (num > count) {
            count = num;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "bpfbhmipx";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
