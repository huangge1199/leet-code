package com.code.leet.contest1;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.solve(new int[][]{{0, 2}, {0, 2}}, new int[]{1, 4, 5, 8, 2}, 3));
    }

    public int solve(int[][] types, int[] nums, int kth) {
        if (types.length == 1) {
            if (types[0][0] == 1) {
                return nums[kth];
            } else {
                return nums[types[0][1] - 1 + kth - 1];
            }
        } else {
            if (types[0][0] == 1) {
                if (types[1][0] == 1) {
                    return nums[kth - 1];
                } else {
                    return nums[types[1][1] - 1 + kth - 1];
                }
            } else {
                if (types[1][0] == 1) {
                    return nums[types[0][1] - 1 + kth - 1];
                } else {
                    return nums[types[0][1] - 1 + types[1][1] - 1 + kth - 1];
                }
            }
        }
    }
}
