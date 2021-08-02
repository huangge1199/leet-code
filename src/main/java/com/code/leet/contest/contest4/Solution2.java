package com.code.leet.contest.contest4;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.countPlans(new int[]{31,18,-11,13},20));
    }

//    public int countPlans(int[] nums, int target) {
//        Arrays.sort(nums);
//        if (nums[0] > target) {
//            return 0;
//        }
//        if (nums[0] >= 0 || nums[nums.length - 1] <= 0) {
//            return count(0, nums.length, target, nums);
//        }
//        int c0 = 0;
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                c0++;
//            } else if (nums[i] > 0) {
//                index = i;
//                break;
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < index - c0; i++) {
//            count += countPlans(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
//        }
//
//        count += count(index, nums.length, target, nums);
//        return count;
//    }
//
//    private int count(int start, int end, int target, int[] nums) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(nums[start]);
//        int sum = nums[start];
//        int count = 0;
//        for (int i = start + 1; i < end; i++) {
//            sum += nums[i];
//            queue.add(nums[i]);
//            while (!queue.isEmpty() && sum > target) {
//                sum -= queue.poll();
//            }
//            if (sum == target) {
//                count++;
//            }
//            if (queue.isEmpty()) {
//                break;
//            }
//        }
//        return count;
//    }

    int count = 0;
    public int countPlans(int[] nums, int target) {
        Arrays.sort(nums);
        count(nums, target, 0, 0);
        return count;
    }

    private void count(int[] nums, int target, int sum, int index) {
        if (sum == target) {
            count++;
            return;
        }
        if (sum > target) {
            return;
        }
        if (index == nums.length) {
            return;
        }
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            count(nums, target, sum + nums[i], index + 1);
            count(nums, target, sum, index + 1);
        }
    }
}
