package com.code.leet.contest.contest2;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }

    public int countOccurrences(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == target && nums[end] == target) {
                return end - start + 1;
            } else if (nums[start] == target && nums[end] > target) {
                end--;
            } else if (nums[end] == target && nums[start] < target) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return 0;
    }
}
