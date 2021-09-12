package com.code.leet.week;

import javafx.util.Pair;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution258 {
    public static void main(String[] args) {
        Solution258 solution = new Solution258();
    }

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index > 0) {
            StringBuilder str = new StringBuilder(word.substring(0, index + 1));
            word = str.reverse() + word.substring(index + 1);
        }
        return word;
    }

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            double key = (double) rectangle[1] / rectangle[0];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long sum = 0;
        for (double key : map.keySet()) {
            if (map.get(key) > 1) {
                sum += (long) map.get(key) * (map.get(key) - 1) / 2;
            }
        }
        return sum;
    }
}
