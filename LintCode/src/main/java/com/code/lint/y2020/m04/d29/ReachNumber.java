package com.code.lint.y2020.m04.d29;

/**
 * @Author: hyy
 * @Date: 2020-04-29 13:21
 */

public class ReachNumber {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        // Write your code here
        int result = 1;
        int sum = 0;
        if(target>0){
            while (sum < target || (sum - target) % 2 == 1) {
                sum += result;
                result++;
            }
        }else{
            while (sum > target || (target - sum) % 2 == 1) {
                sum -= result;
                result++;
            }
        }
        return result - 1;
    }
}
