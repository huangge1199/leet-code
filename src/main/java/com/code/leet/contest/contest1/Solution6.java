package com.code.leet.contest.contest1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int[] nums;
        int[] nums1;
        for (int i = 2; i < 100; i++) {
            nums = new int[i];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = j;
            }
            nums1 = Arrays.copyOf(nums, nums.length);
            int index = 1;
            while (true) {
                nums1 = solution.change(nums1);
                if (solution.bl(nums, nums1)) {
                    System.out.println(i + ":" + index);
                    break;
                }
                index++;
            }
            i++;
        }
    }

    private boolean bl(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public int solve(int[] nums, int m, int kth) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int index = -1;
        for (int i = 0; i < m; i++) {
            nums = change(nums);
            if (bl(nums1, nums)) {
                index = i + 1;
                break;
            }
        }
        if (index > 0) {
            for (int i = 0; i < m % index; i++) {
                nums = change(nums);
                if (bl(nums1, nums)) {
                    index = i + 1;
                    break;
                }
            }
        }
        return nums[kth - 1];
    }

    private int[] change(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                stack.push(nums[i]);
            } else {
                queue.add(nums[i]);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index] = queue.poll();
            index++;
        }
        while (!stack.isEmpty()) {
            nums[index] = stack.pop();
            index++;
        }
        return nums;
    }
}
