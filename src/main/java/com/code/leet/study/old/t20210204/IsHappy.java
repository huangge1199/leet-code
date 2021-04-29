package com.code.leet.study.old.t20210204;

import java.util.ArrayList;
import java.util.List;

public class IsHappy {

    private boolean is(int n, List<Integer> nums) {
        boolean is = false;
        int sum = 0;
        do {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        } while (n >= 10);
        sum += n * n;

        if (sum == 1) {
            is = true;
        } else if (!nums.contains(sum)) {
            nums.add(sum);
            is = is(sum, nums);
        }
        return is;
    }

    public boolean isHappy(int n) {
        List<Integer> nums = new ArrayList<>();
        return is(n, nums);
    }
}
