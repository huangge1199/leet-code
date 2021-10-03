package com.code.leet.doubleWeek;

import java.math.BigInteger;
import java.util.*;

public class SolutionD62 {
    public static void main(String[] args) {
        SolutionD62 solution = new SolutionD62();
        System.out.println(solution.waysToPartition(new int[]{22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] arrs = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arrs[i][j] = original[index];
                index++;
            }
        }
        return arrs;
    }

    public int numOfPairs(String[] nums, String target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)) {
                    result++;
                }
            }
        }
        return result;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        List<int[]> list = new ArrayList<>();
        int index = answerKey.indexOf("T");
        int count = 0;
        for (int i = index; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) == 'T') {
                count++;
            } else {
                int fc = 0;
                for (int j = i; j < answerKey.length(); j++) {
                    if (answerKey.charAt(i) == 'F') {
                        fc++;
                        if (fc == k) {

                        }
                    } else {
                        break;
                    }
                }
                list.add(new int[]{i, count});
            }
        }
        return 0;
    }

    public int waysToPartition(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            if (i < nums.length - 1) {
                List<Integer> list = map.getOrDefault(sums[i + 1], new ArrayList<>());
                list.add(i);
                map.put(sums[i + 1], list);
            }
        }
        int max = 0;
        if (sums[nums.length] % 2 == 0 && map.containsKey(sums[nums.length] / 2)) {
            max = Math.max(max, map.get(sums[nums.length] / 2).size());
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if ((sums[nums.length] + k - nums[i]) % 2 == 0) {
                if (map.containsKey((sums[nums.length] + k - nums[i]) / 2)) {
                    List<Integer> list = map.get((sums[nums.length] + k - nums[i]) / 2);
                    for (int j = 0; j < list.size(); j++) {
                        if (j < i) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                if (map.containsKey(sums[nums.length] - (k - nums[i]) / 2)) {
                    List<Integer> list = map.get(sums[nums.length] - (k - nums[i]) / 2);
                    for (int j = list.size() - 1; j >= 0; j--) {
                        if (j >= i) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
