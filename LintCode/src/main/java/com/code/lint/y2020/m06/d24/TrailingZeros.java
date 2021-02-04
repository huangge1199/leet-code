package com.code.lint.y2020.m06.d24;

/**
 * @Author: hyy
 * @Date: 2020-06-24 09:44
 */

public class TrailingZeros {
    /**
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long count = 0;
        for(int i = 1; Math.pow(5,i) <= n; i++) {
            count += n / (long)Math.pow(5,i);
        }
        return count;
    }
}
