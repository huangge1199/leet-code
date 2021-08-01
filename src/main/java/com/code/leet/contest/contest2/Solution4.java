package com.code.leet.contest.contest2;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.maximumValue(new int[]{1, 4, 5, 8, 2}, new int[]{3, 5, 4}));
    }

    public int maximumValue(int[] nums, int[] arr) {
//        Arrays.sort(nums);
//        Map<Integer, int[]> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            int[] indexs = map.getOrDefault(num, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE});
//            indexs[0] = Math.min(indexs[0], i);
//            indexs[1] = Math.min(indexs[1], nums.length - 1 - i);
//            map.put(num, indexs);
//        }
//
//        long result = 0;
//        for (int key : map.keySet()) {
//            int[] indexs = map.get(key);
//            result = Math.max(result, (long) indexs[0] * indexs[1]);
//        }
//        return (int) (result % 100000007);
        Arrays.sort(nums);
        int size = nums.length;
        List<Integer> list = new ArrayList<>();
        if (size % 2 == 0) {
            list.add(nums[size / 2 - 1]);
        }
        list.add(nums[size / 2]);
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int sub = Integer.MAX_VALUE;
            for (int mid : list) {
                sub = Math.min(Math.abs(arr[i] - mid), sub);
            }
            if (sub < min) {
                min = sub;
                index = i;
            }
        }
        long result;
        int mid = size / 2;
        if (size % 2 == 1) {
            if (arr[index] < nums[mid]) {
                mid--;
                while (arr[index] <= nums[mid]) {
                    if(arr[index] == nums[mid]){
                        size--;
                    }
                    mid--;
                }
            } else if (arr[index] >= nums[mid]) {
                if(arr[index] == nums[mid]){
                    size--;
                }
                mid++;
                while (arr[index] >= nums[mid]) {
                    if(arr[index] == nums[mid]){
                        size--;
                    }
                    mid++;
                }
            }
        } else {
            int left = mid - 1;
            int right = mid;
            int count = 0;
            while (arr[index] <= nums[left] || arr[index] >= nums[right]) {
                if(arr[index] == nums[left]){
                    size--;
                }
                if(arr[index] == nums[right]){
                    size--;
                }
                left--;
                right++;
                count++;
            }
            mid = mid - 1 - count;
        }
        result = (long) mid * (size - mid);
        return (int) (result % 100000007);
    }
}
