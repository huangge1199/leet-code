package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 22:59
 */

public class SearchInsert {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        int i=0;
        for(i=0;i<A.length;i++){
            if(A[i]>=target) {
                break;
            }
        }
        return i;
    }
}
