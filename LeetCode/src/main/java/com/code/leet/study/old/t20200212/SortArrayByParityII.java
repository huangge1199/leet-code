package com.code.leet.study.old.t20200212;

/**
 * 922. 按奇偶排序数组 II
 *
 * @Author: hyy
 * @Date: 2020-02-12 11:07
 */

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int j = i + 1;
            while ((A[i] - i) % 2 == 1) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
        }
        return A;
    }
}
