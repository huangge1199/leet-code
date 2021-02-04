package com.code.lint.y2020.m02.d11;

/**
 * @Author: hyy
 * @Date: 2020-02-11 13:14
 */

public class SearchRange {
    /**
     * @param A:      an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = A.length;
        while (start <= end) {
            if (A[start] > target || A[end] < target) {
                break;
            } else {
                if(A[start] == target&&A[end]==target){
                    result = new int[]{start,end};
                    break;
                }
                if (A[start] < target) {
                    start++;
                }
                if(A[end]>target){
                    end--;
                }
            }
        }
        return result;
    }
}
