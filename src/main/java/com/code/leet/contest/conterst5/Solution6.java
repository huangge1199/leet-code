package com.code.leet.contest.conterst5;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        TwoArray twoArray = new TwoArray("[[2,3],[1,3],[3,4],[1,2]]", true);
        System.out.print(solution.solve(twoArray.getArr()));
    }

    int max = Integer.MIN_VALUE;

    public int solve(int[][] intervals) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] interval : intervals) {
            List<Integer> list = map.getOrDefault(interval[0], new ArrayList<>());
            list.add(interval[1]);
            map.put(interval[0], list);
        }
        dfs(map, intervals.length, 0, 1);
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    private void dfs(Map<Integer, List<Integer>> map, int n, int count, int index) {
        if (index == n) {
            max = Math.max(max, count);
            return;
        }

        List<Integer> list = map.getOrDefault(index, new ArrayList<>());
        for (Integer integer : list) {
            dfs(map, n, count + 1, integer);
        }
    }
}
