package com.code.lint.y2020.m01.d25;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-25 19:12
 */

public class NarcissisticNumbers {
    public static void main(String[] args) {
        for (Integer i:getNarcissisticNumbers(3)
             ) {
            System.out.println(i);
        }
    }
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public static List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> nums = new ArrayList<>();
        int min = (int)Math.pow(10,n-1);
        if(n==1){
            min=0;
        }
        int max = (int)Math.pow(10,n);
        for (int i = min; i < max; i++){
            int temp = i;
            int j = 0;
            int sum = 0;
            while(temp>10){
                sum += Math.pow(temp % 10,n);
                temp /= 10;
                j++;
            }
            sum += Math.pow(temp % 10,n);
            if(sum==i){
                nums.add(i);
            }
        }
        return nums;
    }
}
