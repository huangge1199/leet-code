package com.code.lint.y2020.m02.d11;

/**
 * 63. 搜索旋转排序数组 II
 *
 * 跟进“搜索旋转排序数组”，假如有重复元素又将如何？
 *
 * 是否会影响运行时间复杂度？
 *
 * 如何影响？
 *
 * 为何会影响？
 *
 * 写出一个函数判断给定的目标值是否出现在数组中。
 *
 * @Author: hyy
 * @Date: 2020-02-11 11:21
 */

public class Search {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean
     */
    public boolean search1(int[] A, int target) {
        // write your code here
        boolean isIn = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                isIn = true;
                break;
            }
        }
        return isIn;
    }
}
