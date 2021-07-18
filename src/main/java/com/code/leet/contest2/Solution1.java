package com.code.leet.contest2;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }

    public int minimumWaitingTime(int[] w) {
        int[] wait = new int[w.length];
        Arrays.sort(w);
        int sum = 0;
        for (int i = 1; i < w.length; i++) {
            wait[i] = wait[i - 1] + w[i - 1];
            sum += wait[i];
        }
        return sum;
    }
}
