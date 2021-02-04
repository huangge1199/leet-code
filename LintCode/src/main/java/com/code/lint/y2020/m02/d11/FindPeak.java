package com.code.lint.y2020.m02.d11;

/**
 * 75. 寻找峰值
 *
 * 你给出一个整数数组(size为n)，其具有以下特点：
 *
 *     相邻位置的数字是不同的
 *     A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 *
 * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 *
 * @Author: hyy
 * @Date: 2020-02-11 11:25
 */

public class FindPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public static int findPeak(int[] A) {
        // write your code here
        int start = 1;
        int end = A.length - 2;
        int index = (start + end) / 2;
        while (start < index && index < end) {
            if (index > 0 && A[index - 1] < A[index] && A[index] > A[index + 1]) {
                break;
            } else if (A[index - 1] > A[index]) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = (start + end) / 2;
        }
        if (A[start] > A[start - 1] && A[start] > A[start + 1]) {
            index = start;
        } else if (A[end] > A[end +-1] && A[end] > A[end + 1]) {
            index = end;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,102,104,7,9,11,4,3};
        System.out.println(findPeak(nums));
    }
}
