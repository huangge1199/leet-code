package com.code.leet.weekold;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 轩辕龙儿
 * Date: 2021/3/20
 * Time: 22:31
 * Description: No Description
 */
public class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int second = -2;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            String temp;
            temp = i + 1 < size ? s.substring(i, i + 1) : s.substring(i);
            if (temp.matches("[0-9]+")) {
                int cur = Integer.parseInt(temp);
                if (cur > max) {
                    second = max;
                    max = cur;
                } else if (cur > second && cur != max) {
                    second = cur;
                }
            }
        }
        return second > 0 ? second : -1;
    }

    public static void main(String[] args) {
//        getMaximumConsecutive(new int[]{1,1,1,4});
        int[][] orders = new int[][]{{23,8,0},{28,29,1},{11,30,1},{30,25,0},{26,9,0},{3,21,0},{28,19,1},{19,30,0},{20,9,1},{17,6,0}};
        Solution solution = new Solution();
        solution.getNumberOfBacklogOrders(orders);
    }

//    public static int getMaximumConsecutive(int[] coins) {
//        int size = coins.length;
//        for (int i = 0; i < size; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if (coins[j] < coins[i]) {
//                    int temp = coins[j];
//                    coins[j] = coins[i];
//                    coins[i] = temp;
//                }
//            }
//        }
//        int num = 1;
//        while (isTrue(coins, num)) {
//            num++;
//        }
//        return num - 1;
//    }
//
//    private static boolean isTrue(int[] arr, int num) {
//        if (num == 0) {
//            return true;
//        }
//        int size = arr.length;
//        int index = -1;
//        for (int i = 0; i < size; i++) {
//            if (arr[i] > num) {
//                index = i;
//                break;
//            }
//        }
//        if (index == -1) {
//            return false;
//        }
//        for (int i = 0; i < index; i++) {
//            int[] newArr = new int[index - i - 1];
//            for (int j = i + 1; j < index; j++) {
//                newArr[j] = arr[j];
//            }
//            if (isTrue(newArr, num - arr[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int size = nums.length;
        int sum = nums[0];
        for (int i = 1; i < size; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                max = Math.max(sum, max);
                sum = nums[i];
            }
        }
        max = Math.max(sum, max);
        return max;
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        List<int[]> orderList = new ArrayList<>();
        int length = orders.length;
        long num = 0;
        for (int i = 0; i < length; i++) {
            int size = orderList.size();
            for (int j = 0; j < size; j++) {
                if (orders[i][2] - orderList.get(j)[2] != 0) {
                    boolean buy = orders[i][2] == 0 && orderList.get(j)[0] <= orders[i][0];
                    boolean sell = orders[i][2] == 1 && orderList.get(j)[0] >= orders[i][0];
                    if (buy || sell) {
                        if (orderList.get(j)[1] < orders[i][1]) {
                            orders[i][1] -= orderList.get(j)[1];
                            num -= orderList.get(j)[1];
                            orderList.remove(orderList.get(j));
                            size = orderList.size();
                            j--;
                        } else if (orderList.get(j)[1] > orders[i][1]) {
                            num -= orders[i][1];
                            orderList.get(j)[1] -= orders[i][1];
                            orders[i][1] = 0;
                            break;
                        }
                    }
                }
            }
            size = orderList.size();
            if (orders[i][1] > 0) {
                boolean isTrue = true;
                for (int j = 0; j < size; j++) {
                    if (orders[i][2] == orderList.get(j)[2]) {
                        if (orders[i][2] == 0 && orders[i][0] > orderList.get(j)[0]) {
                            num += orders[i][1];
                            orderList.add(j, orders[i]);
                            isTrue = false;
                            break;
                        }
                        if (orders[i][2] == 1 && orders[i][0] < orderList.get(j)[0]) {
                            num += orders[i][1];
                            orderList.add(j, orders[i]);
                            isTrue = false;
                            break;
                        }
                    }
                }
                if (isTrue) {
                    num += orders[i][1];
                    orderList.add(orders[i]);
                }
            }
        }
        return (int)(num % (Math.pow(10, 9) + 7));
    }
}
