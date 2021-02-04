package com.code.lint.y2020.m02.d10;

/**
 * @Author: hyy
 * @Date: 2020-02-10 23:42
 */

public class KthLargestElement {
    /**
     * @param n:    An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
//    public static int kthLargestElement(int n, int[] nums) {
//        // write your code here
//        if(nums==null||nums.length==0){
//            return -1;
//        }
//        return quickSort(nums,0,nums.length-1,n);
//    }
//
//    public int quickSort(int[] nums,int start,int end,int k){
//        if(start==end){
//            return nums[k];
//        }
//        int left = start;
//        int right=end;
//        int point=nums[(start+end)/2];
//        while (left<=right){
//            while (left<=right&&nums[left]<point){
//                left++;
//            }
//            while (left<=right&&nums[right]>point){
//                left--;
//            }
//            if(left<=right){
//                int temp=nums[left];
//                nums[left]=nums[right];
//                nums[right]=temp;
//                left++;
//                right--;
//            }
//        }
//        if(k<=right){
//            return quickSort(nums,start,right,k);
//        }
//        if(start+k-1>=left){
//            return quickSort(nums,left,end,k);
//        }
//        return nums[k];
//    }

    public int kthLargestElement(int n, int[] nums) {
        int begin = 0, end = nums.length - 1;
        int pos = 0;
        while (begin <= end) {
            pos = partion(nums, begin, end);
            if (pos == n - 1) {
                return nums[pos];
            } else if (pos > n - 1) {
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
            while (begin < end && data[end] <= temp) {
                end--;
            }
            swap(data, begin, end);
            while (begin < end && data[begin] > temp) {
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
}
