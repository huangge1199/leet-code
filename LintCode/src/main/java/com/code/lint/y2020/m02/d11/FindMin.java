package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 11:16
 */

public class FindMin {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
