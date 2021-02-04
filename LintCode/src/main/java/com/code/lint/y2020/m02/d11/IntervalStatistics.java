package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 02:33
 */

public class IntervalStatistics {
    /**
     * @param arr: the 01 array
     * @param k:   the limit
     * @return: the sum of the interval
     */
    public static long intervalStatistics(int[] arr, int k) {
        // Write your code here.
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                continue;
            }
            int num = 0;
            for (int j = i; j < arr.length; j++) {
                if(arr[j]!=0){
                    if (arr[j] == 1) {
                        num++;
                    }
                    continue;
                }
                if (num <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 0, 1, 1, 0};
        System.out.println(intervalStatistics(nums, 1));
    }
}
