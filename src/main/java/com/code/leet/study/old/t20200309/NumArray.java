package com.code.leet.study.old.t20200309;

/**
 * @Author: hyy
 * @Date: 2020-03-09 22:10
 */

public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        this.nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (; i <= j; i++) {
            sum += this.nums[i];
        }
        return sum;
    }
}
