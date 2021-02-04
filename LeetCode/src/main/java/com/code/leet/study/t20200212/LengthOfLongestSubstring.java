package com.code.leet.study.t20200212;

/**
 * 3. 无重复字符的最长子串
 *
 * @Author: hyy
 * @Date: 2020-02-12 17:41
 */

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int length = 1;
        int count = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            int index = s.substring(start, i).indexOf(s.substring(i, i + 1));
            if (index == -1) {
                count++;
            } else {
                if (count > length) {
                    length = count;
                }
                count = i - index - start;
                start = start + index + 1;
            }
        }
        if (count > length) {
            length = count;
        }
        return length;
    }
}
