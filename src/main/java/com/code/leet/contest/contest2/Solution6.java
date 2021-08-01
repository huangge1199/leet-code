package com.code.leet.contest.contest2;

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        solution.solve(new int[]{-3, -1, 2, -3, -2, -5}, new int[][]{{2, 5}, {1, 1}, {2, 3}, {4, 5}, {0, 5}});
    }

    public int[] solve(int[] nums, int[][] queries) {
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if(i==j){
//                    dp[i][j] = nums[j];
//                }else{
//                    dp[i][j] = Math.max(dp[i][j-1],nums[j]);
//                }
//            }
//        }
//        int[] result = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            result[i] = dp[queries[i][0]][queries[i][1]];
//        }
//        return result;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] arrays = Arrays.copyOfRange(nums, queries[i][0], queries[i][1] + 1);
            Arrays.sort(arrays);
            result[i] = arrays[arrays.length - 1];
        }
        return result;
    }
}
