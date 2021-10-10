package com.code.leet.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution262 {
    public static void main(String[] args) {
        Solution262 solution = new Solution262();
//        solution.minOperations(new int[][]{{2,4},{6,8}},2);
//        solution.minOperations(new int[][]{{931, 128}, {639, 712}}, 73);
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        stockPrice.update(2,5);
        stockPrice.current();
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 || nums1[i] != nums1[i - 1]) {
                temp.add(nums1[i]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i == 0 || nums2[i] != nums2[i - 1]) {
                int num = nums2[i];
                if (temp.contains(num)) {
                    if (!result.contains(num)) {
                        result.add(num);
                    }
                } else {
                    temp.add(num);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            if (i == 0 || nums3[i] != nums3[i - 1]) {
                int num = nums3[i];
                if (temp.contains(num)) {
                    if (!result.contains(num)) {
                        result.add(num);
                    }
                } else {
                    temp.add(num);
                }
            }
        }
        return result;
    }

    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(ints[j]);
            }
        }
        Collections.sort(list);
        int num = list.get(0);
        list.set(0, 0);
        boolean bl = true;
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i) - num) % x == 0) {
                list.set(i, (list.get(i) - num) / x);
                sum += list.get(i);
            } else {
                bl = false;
                break;
            }
        }
        int bef = sum;
        for (int i = 1; i < list.size(); i++) {
            bef += (-list.size() + 2 * i) * list.get(i);
            sum = Math.min(sum, bef);
        }
        return bl ? sum : -1;
    }

}
