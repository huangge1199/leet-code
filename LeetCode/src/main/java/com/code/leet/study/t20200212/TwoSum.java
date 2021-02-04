package com.code.leet.study.t20200212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 两数之和
 *
 * @Author: hyy
 * @Date: 2020-02-12 11:25
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        if (nums.length == 2) {
            result[0] = start;
            result[1] = end;
        } else {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Arrays.sort(nums);
            while (nums[start] + nums[end] != target) {
                if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
            result[0] = list.indexOf(nums[start]);
            list.remove(result[0]);
            result[1] = list.indexOf(nums[end]);
            if (result[1] >= result[0]) {
                result[1]++;
            }
            if (result[0] > result[1]) {
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
        }
        return result;
    }
}
