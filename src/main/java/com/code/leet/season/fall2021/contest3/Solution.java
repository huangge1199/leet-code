package com.code.leet.season.fall2021.contest3;

import com.code.leet.entiy.TwoArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/9/25-15:16
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        TwoArray edges = new TwoArray("[[0,1],[1,2]]", true);
//        TwoArray plans = new TwoArray("[[2,1],[1,0],[3,0]]", true);
//        solution.volunteerDeployment(new int[]{1, 16}, 21, edges.getArr(), plans.getArr());
        TwoArray edges = new TwoArray("[[0,3],[1,3],[4,3],[2,3],[2,5]]", true);
        TwoArray plans = new TwoArray("[[1,1],[3,3]", true);
        solution.volunteerDeployment(new int[]{4, 13, 4, 3, 8}, 54, edges.getArr(), plans.getArr());
    }

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        long[][] result = new long[finalCnt.length + 1][2];
        result[0][1] = 1;
        for (int i = 0; i < finalCnt.length; i++) {
            result[i + 1][0] = finalCnt[i];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], new ArrayList<>(list));
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], new ArrayList<>(list));
        }
        for (int i = plans.length - 1; i >= 0; i--) {
            int index = plans[i][1];
            if (plans[i][0] == 1) {
                result[index][0] *= 2;
                result[index][1] *= 2;
            } else if (plans[i][0] == 2) {
                List<Integer> list = map.getOrDefault(index,new ArrayList<>());
                for (int num : list) {
                    result[num][0] -= result[index][0];
                    result[num][1] -= result[index][1];
                }
            } else {
                List<Integer> list = map.getOrDefault(index,new ArrayList<>());
                for (int num : list) {
                    result[num][0] += result[index][0];
                    result[num][1] += result[index][1];
                }
            }
        }
        int count = 0;
        for (long[] longs : result) {
            totalNum -= longs[0];
            count += longs[1];
        }
        int[] nums = new int[result.length];
        int num = count == 0 ? 0 : (int) (totalNum / count);
        for (int i = 0; i < result.length; i++) {
            nums[i] = (int) (result[i][0] + result[i][1] * num);
        }
        return nums;
    }
}
