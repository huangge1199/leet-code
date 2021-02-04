package com.code.lint.y2020.m02.d10;

/**
 * 整数排序 II
 * @Author: hyy
 * @Date: 2020-02-10 20:11
 */

public class SortColors2 {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] > colors[j]) {
                    int temp = colors[i];
                    colors[i] = colors[j];
                    colors[j] = temp;
                }
            }
        }
    }
}
