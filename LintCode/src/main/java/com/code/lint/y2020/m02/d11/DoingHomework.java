package com.code.lint.y2020.m02.d11;

import java.util.Arrays;

/**
 * @Author: hyy
 * @Date: 2020-02-11 17:21
 */

public class DoingHomework {
    /**
     * @param cost: the cost
     * @param val:  the val
     * @return: the all cost
     */
    public static long doingHomework(int[] cost, int[] val) {
        // Write your code here.
        long sums = 0;
        long sum = 0;
        int index = 0;
        Arrays.sort(val);
        for (int i = 0; i < val.length; i++) {
            val[i] -= sum;
            if (val[i] < cost[index]) {
                continue;
            }
            int j = 0;
            for (j = index; j < cost.length; j++) {
                if (val[i] >= cost[j]) {
                    sums += cost[j] * (val.length - i);
                    sum += cost[j];
                    val[i] -= cost[j];
                } else {
                    index = j;
                    break;
                }
            }
            if (j == cost.length) {
                break;
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{3, 3, 3};
        int[] val = new int[]{7, 15, 11, 13, 1, 6, 11, 15, 11, 1, 8, 9, 13, 9, 1};
        System.out.println(doingHomework(cost, val));
    }
}
