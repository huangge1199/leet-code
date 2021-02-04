package com.code.lint.y2020.m01.d26;

/**
 * @Author: hyy
 * @Date: 2020-01-26 00:04
 */

public class Deduplication {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public static int deduplication(int[] nums) {
        // write your code here
        int num = nums.length;
        for (int i=0;i<num;i++){
            for (int j=i+1;j<num;j++){
                while(nums[i]==nums[j]&&j<num){
                    int temp = nums[j];
                    nums[j] = nums[num-1];
                    nums[num-1] = temp;
                    num--;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,4,4,2};
        int n = deduplication(nums);
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
    }
}
