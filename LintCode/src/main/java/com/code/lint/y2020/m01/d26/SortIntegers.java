package com.code.lint.y2020.m01.d26;

/**
 * @Author: hyy
 * @Date: 2020-01-26 00:39
 */

public class SortIntegers {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        for (int i=0;i<A.length;i++){
            for (int j=0;j<A.length;j++){
                if(A[i]<A[j]){
                    int temp = A[i];
                    A[i]=A[j];
                    A[j]=temp;
                }
            }
        }
    }
}
