package com.code.leet.doubleWeek;

import java.util.Arrays;

public class SolutionD55 {
    public static void main(String[] args) {
        SolutionD55 solution = new SolutionD55();
//        System.out.println(solution.canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(solution.maxAlternatingSum(new int[]{2, 1, 5, 4, 4}));
    }

    public boolean canBeIncreasing(int[] nums) {
        return countDel(nums, 0) < 2;
    }

    private int countDel(int[] nums, int count) {
        int size = nums.length - 1;
        for (int i = 0; i < size; i++) {
            if (nums[i] >= nums[i + 1]) {
                count++;
                int[] aft;
                int[] bef;
                if (i > 0) {
                    bef = new int[size - i + 1];
                    bef[0] = nums[i - 1];
                    for (int j = i + 1; j <= size; j++) {
                        bef[j - i] = nums[j];
                    }
                    aft = Arrays.copyOf(bef, size - i + 1);
                    aft[1] = nums[i];
                } else {
                    bef = Arrays.copyOfRange(nums, 1, size);
                    aft = bef;
                }
                count = Math.min(countDel(bef, count), countDel(aft, count));
                if (count > 2) {
                    return count;
                }
            }
        }
        return count;
    }

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replace(part, "");
        }
        return s;
    }

    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] temp = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(nums[0] - min(temp), maxAlternatingSum(temp));
    }

    private long min(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0] - nums[1], nums[1] - nums[0]);
        }
        int[] temp = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.min(nums[0] - maxAlternatingSum(temp), min(temp));
    }
}
