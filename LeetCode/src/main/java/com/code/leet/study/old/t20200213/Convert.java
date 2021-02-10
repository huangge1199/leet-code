package com.code.leet.study.old.t20200213;

/**
 * 6. Z 字形变换
 *
 * @Author: hyy
 * @Date: 2020-02-13 14:52
 */

public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s == null) {
            return s;
        }
        String[] strs = new String[numRows];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "";
        }
        String str = "";
        int forNum = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int index = (i + 1) % forNum;
            if (index > numRows) {
                strs[forNum + 1 - index] += "" + s.charAt(i);
            } else if (index == 0) {
                strs[1] += "" + s.charAt(i);
            } else {
                strs[index - 1] += "" + s.charAt(i);
            }
        }
        for (String temp : strs) {
            str += temp;
        }
        return str;
    }
}
