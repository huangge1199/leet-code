package com.code.leet.doubleWeek;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionD53 {
    public static void main(String[] args) {
        SolutionD53 solution = new SolutionD53();
//        System.out.println(Arrays.toString(solution.getBiggestThree(new int[][]{{3, 4, 5, 1, 3}, {3, 3, 4, 2, 3}, {20, 30, 200, 40, 10}, {1, 5, 5, 4, 1}, {4, 3, 2, 2, 5}})));
        System.out.println(Arrays.toString(solution.getBiggestThree(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.toString(solution.getBiggestThree(new int[][]{{7, 7, 7}})));
    }

    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) != s.charAt(i) && s.charAt(i - 1) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            max = Math.max(nums[i] + nums[length - 1 - i], max);
        }
        return max;
    }

    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        new TreeSet<>(Comparator.reverseOrder());
        int xLength = grid.length;
        int yLength = grid[0].length;
        int size = (Math.min(xLength, yLength) + 1) / 2;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < xLength - i; j++) {
                for (int k = i; k < yLength - i; k++) {
                    int sum = 0;
                    for (int x = j - i; x <= j + i; x++) {
                        int cha = i - Math.abs(j - x);
                        if (Math.abs(j - x) == i) {
                            sum += grid[x][k + cha];
                        } else {
                            sum += grid[x][k - cha] + grid[x][k + cha];
                        }
                    }
                    set.add(sum);
                }
            }
        }
        List<Integer> list = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int length = Math.min(list.size(), 3);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        return 0;
    }

}
