package com.code.leet.contest.conterst5;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }

    public int maximumGoodsValue(int[][] goods, int maxWeight) {
        int[][] dp = new int[goods.length + 1][maxWeight + 1];
        for (int i = 1; i <= goods.length; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (j >= goods[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - goods[i - 1][0]] + goods[i - 1][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[goods.length][maxWeight];
    }
}

