package com.code.war.study.t20200624;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-06-24 15:10
 */

public class Hamming {

    public static long hamming(int n) {
        List<Long> result = new ArrayList<>();
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        int count = 1;
        result.add(1L);
        while (n > count) {
            long temp = Math.min(Math.min(result.get(num2) * 2, result.get(num3) * 3), result.get(num5) * 5);
            if (temp == result.get(num2) * 2) {
                num2++;
            }
            if (temp == result.get(num3) * 3) {
                num3++;
            }
            if (temp == result.get(num5) * 5) {
                num5++;
            }
            count++;
            result.add(temp);
        }
        return result.get(result.size() - 1);
    }
}
