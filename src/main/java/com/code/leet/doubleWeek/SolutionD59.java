package com.code.leet.doubleWeek;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class SolutionD59 {
    public static void main(String[] args) {
        SolutionD59 solution = new SolutionD59();

//        System.out.println(solution.minTimeToType("abc"));
//        System.out.println(solution.minTimeToType("bza"));
//        System.out.println(solution.minTimeToType("zjpc"));

//        TwoArray twoArray = new TwoArray("[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]", true);
//        System.out.println(solution.countPaths(7, twoArray.getArr()));
    }

    public int minTimeToType(String word) {
        int time = 0;
        char[] chs = word.toCharArray();
        time += chs.length;
        time += Math.min(26 - Math.abs(chs[0] - 'a'), Math.abs(chs[0] - 'a'));
        for (int i = 1; i < chs.length; i++) {
            int abs = Math.abs(chs[i] - chs[i - 1]);
            time += Math.min(26 - abs, abs);
        }
        return time;
    }

    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        long mul = 1;
        int count = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(ints[j]);
                if (ints[j] != 0) {
                    mul = mul * ints[j] > 0 ? 1 : -1;
                    min = Math.min(min, Math.abs(ints[j]));
                } else {
                    count++;
                }
            }
        }
        return mul < 0 && count == 0 ? sum - 2L * min : sum;
    }

    private int min = Integer.MAX_VALUE;
    private int count = 0;

    public int countPaths(int n, int[][] roads) {
        int[][] arrs = new int[n][n];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            arrs[road[0]][road[1]] = road[2];
            arrs[road[1]][road[0]] = road[2];
        }
        boolean[] use = new boolean[n];
        use[0] = true;
        dfs(arrs, 0, use, 0);
        return count;
    }

    private void dfs(int[][] arrs, int index, boolean[] use, int times) {
        if (times > min) {
            return;
        }
        if (index == arrs.length - 1) {
            if (times < min) {
                min = times;
                count = 1;
            } else if (times == min) {
                count++;
            }
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[index][i] == 0 || use[i]) {
                continue;
            }
            use[i] = true;
            dfs(arrs, i, use, times + arrs[index][i]);
            use[i] = false;
        }
    }

}
