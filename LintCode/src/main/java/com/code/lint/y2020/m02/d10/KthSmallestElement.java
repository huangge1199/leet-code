package com.code.lint.y2020.m02.d10;

/**
 * @Author: hyy
 * @Date: 2020-02-10 21:05
 */

public class KthSmallestElement {
    /**
     * @param k:    An integer
     * @param nums: An array
     * @return: the Kth largest element
     */

    public static int kthSmallest(int k, int[] nums) {
        int begin = 0, end = nums.length - 1;
        int pos = 0;
        while (begin <= end) {
            pos = partion(nums, begin, end);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                end = pos - 1;
            } else {
                begin = pos + 1;
            }
        }
        return -1;
    }

    private static int partion(int[] data, int begin, int end) {
        int temp = data[begin];
        while (begin < end) {
            while (begin < end && data[end] >= temp) {
                end--;
            }
            swap(data, begin, end);
            while (begin < end && data[begin] < temp) {
                begin++;
            }
            swap(data, begin, end);
        }
        return begin;
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || i >= arr.length || j >= arr.length || i < 0 || j < 0) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 2, 4, 8};
        System.out.println(kthSmallest(1, nums));
    }
}
