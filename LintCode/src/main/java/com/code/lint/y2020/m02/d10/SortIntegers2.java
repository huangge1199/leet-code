package com.code.lint.y2020.m02.d10;

/**
 * @Author: hyy
 * @Date: 2020-02-10 20:18
 */

public class SortIntegers2 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A,0,A.length-1);
    }

    public static void quickSort(int[] nums,int start,int end){
        if(start<end){
            int index = getIndex(nums,start,end);
            quickSort(nums,start,index-1);
            quickSort(nums,index+1,end);
        }
    }

    public static int getIndex(int[] nums,int start,int end){
        int temp = nums[start];
        while (start<end){
            while (start<end&&nums[end]>=temp){
                end--;
            }
            nums[start]=nums[end];
            while(start<end&&nums[start]<=temp){
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start]=temp;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5};
        sortIntegers2(nums);
    }
}
