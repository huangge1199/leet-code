package com.code.leet.study.t20210204;

/**
 *
 */
public class IsHappy {
    public boolean isHappy(int n) {
        boolean is = false;
        int sum = 0;
        do {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        } while (n >= 10);
        sum += n * n;
        if (sum >= 10) {
            isHappy(sum);
        } else {
            is = sum == 1;
        }
        return is;
    }


}
