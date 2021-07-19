package com.code.leet.contest2;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        solution.maximumScore(2, new int[][]{{4, 3}, {2, 1}, {0, 5}, {4, 1}});
    }

    private int max = -1;

    public int maximumScore(int atk, int[][] monsters) {
        attack(atk, monsters, 0, new ArrayList<>());
        return max;
    }

    private void attack(int atk, int[][] monsters, int score, List<Integer> use) {
        if (use.size() == monsters.length) {
            max = Math.max(max, score);
        }
        for (int i = 0; i < monsters.length; i++) {
            if (use.contains(i)) {
                continue;
            }
            if (monsters[i][0] <= atk) {
                use.add(i);
                attack(atk + monsters[i][1], monsters, score + atk - monsters[i][0], use);
                use.remove(use.size() - 1);
            }
        }
    }
}
