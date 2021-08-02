package com.code.leet.contest.contest4;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        solution.shiftMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}},new int[][]{{3,1,9},{4,5,2},{7,8,6}});
    }

    public int shiftMatrix(int[][] source, int[][] target) {
        Map<Integer, Pair<Integer, Integer>[]> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (source[i][j] != target[i][j]) {
                    Pair<Integer,Integer> pair = new Pair<>(i,j);
                    Pair[] temp = map.getOrDefault(source[i][j], new Pair[2]);
                    temp[0] = pair;
                    map.put(source[i][j],temp);
                    temp = map.getOrDefault(target[i][j], new Pair[2]);
                    temp[1] = pair;
                    map.put(target[i][j],temp);
                }
            }
        }
        int max = 0;
        for (int key : map.keySet()) {
            Pair<Integer, Integer>[] pairs = map.get(key);
            int x = pairs[1].getKey() - pairs[0].getKey();
            int y = pairs[1].getValue() - pairs[0].getValue();
            x = x >= 0 ? x : x + 3;
            y = y >= 0 ? y : y + 3;
            max = Math.max(x + y, max);
        }
        return max;
    }
}
