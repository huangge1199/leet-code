package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 22:33
 */

public class TwoSum {
    /**
     * @param nums:   an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (nums[start] + nums[end] != target) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        result[0] = start + 1;
        result[1] = end + 1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(twoSum(nums, 9));
    }

}
