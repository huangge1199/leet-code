package com.code.lint.y2020.m02.d10;

/**
 * @Author: hyy
 * @Date: 2020-02-10 20:35
 */

public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        // write your code here
        int max = nums.length;
        if (max > 0) {
            for (int i = 0; i < max; i++) {
                while (nums[i] >= k) {
                    int temp = nums[i];
                    nums[i] = nums[max - 1];
                    nums[max - 1] = temp;
                    max--;
                    if(i==max){
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        System.out.println(partitionArray(nums,2));
    }
}
