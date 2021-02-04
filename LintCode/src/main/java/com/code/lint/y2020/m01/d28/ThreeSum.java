package com.code.lint.y2020.m01.d28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 三数之和
 *
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 *
 * @Author: hyy
 * @Date: 2020-01-28 15:16
 */

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
//    static List<List<Integer>> result = new ArrayList<>();
//    static LinkedList<Integer> sum = new LinkedList<>();

//    public static List<List<Integer>> threeSum(int[] numbers) {
//        // write your code here
//        List<Integer> date = new ArrayList<>();
//        for (int i=0;i<numbers.length;i++){
//            for(int j=i+1;j<numbers.length;j++){
//                if(numbers[i]>numbers[j]){
//                    int temp = numbers[i];
//                    numbers[i] = numbers[j];
//                    numbers[j] = temp;
//                }
//            }
//            date.add(numbers[i]);
//        }
//        for (int i=2;i<date.size();i++){
//            if(date.get(i).equals(date.get(i-2))){
//                date.remove(i);
//            }
//        }
//        getData(date,sum,3);
//        for (int i=result.size()-1;i>=0;i--){
//            List<Integer> nums = result.get(i);
//            int sum = 0;
//            for(int num:nums){
//                sum += num;
//            }
//            if(sum!=0){
//                result.remove(nums);
//            }
//        }
//        for (int i=0;i<result.size();i++){
//            for(int j=result.size()-1;j>i;j--){
//                if(result.get(j).get(0).equals(result.get(i).get(0))&&result.get(j).get(1).equals(result.get(i).get(1))){
//                    result.remove(j);
//                }
//            }
//            date.add(numbers[i]);
//        }
//        if(result.size()==1&&result.get(0).size()==0){
//            result = null;
//        }
//        return result;
//    }
//    public static void getData(List<Integer> date, LinkedList<Integer> sum, int length){
//        if(length==0){
//            result.add((List<Integer>)sum.clone());
//            return;
//        }
//        for (int i=0;i<date.size();i++){
//            sum.addLast(date.get(i));
//            List<Integer> newDate = new ArrayList<>(date);
//            for (int j=i;j>=0;j--){
//                newDate.remove(j);
//            }
//            getData(newDate,sum,length-1);
//            sum.removeLast();
//        }
//    }
    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            int target = numbers[i];
            sum(numbers, left, right, target, result);
        }
        return result;
    }

    public static void sum(int[] numbers, int left, int right, int target, List<List<Integer>> result) {
        int oldLeft = 0;
        int status = 1;
        while (left < right) {
            if (numbers[left] + numbers[right] + target == 0) {
                List<Integer> list = new ArrayList<>();
                if (status == 1) {
                    list.add(target);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    result.add(list);
                    oldLeft = numbers[left];
                    status = 0;
                } else if (oldLeft != numbers[left]) {
                    list.add(target);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    result.add(list);
                    oldLeft = numbers[left];
                }
                left++;
                right--;
                status = 0;
            } else if (numbers[left] + numbers[right] + target < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 92, 0, -3002, 0, 0, 0, -10, -19, 0, 65, 0, 0, 293, 0, 1, 1, 1, 9, 9, 9, 10, 11, 1001, 2001, -404, 201, 203, 201, 999, 345, 1, 1, 1, 1, 1, 1, 1, -2, 1, 1, 1, 1, 1, 1, 1, 1, -2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1200, 1, 1, 1, 1, 1, 2, 1202, 2, 2, -4, 2, 2, 2, 2, 4, 5, 6, 1, 1, -11, 1, 1, 1, 1, 1, 1, 1, 1, 101, 1, 1, 1, 1, 1, -1, 1, -6};
        threeSum(nums);
    }
}
