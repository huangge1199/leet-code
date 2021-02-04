package com.code.lint.y2020.m01.d27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 19:26
 */

public class GetWays {
    /**
     * @param a: the n numbers
     * @param k: the number of integers you can choose
     * @return: how many ways that the sum of the k integers is a prime number
     */
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> sum = new LinkedList<>();

    public static int getWays(int[] a, int k) {
        // Write your code here
        List<Integer> date = new ArrayList<>();
        int count = 0;
        for (int i=0;i<a.length;i++){
            date.add(a[i]);
        }
        getData(date,sum,k);
        for (List<Integer> nums:result){
            boolean flag = true;
            int sum=0;
            for (int num:nums){
                sum+=num;
            }
            for (int i=2;i<sum;i++){
                if(sum%i==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }

    public static void getData(List<Integer> date,LinkedList<Integer> sum,int length){
        if(length==0){
            result.add((List<Integer>)sum.clone());
            return;
        }
        for (int i=0;i<date.size();i++){
            sum.addLast(date.get(i));
            List<Integer> newDate = new ArrayList<>(date);
            for (int j=i;j>=0;j--){
                newDate.remove(j);
            }
            getData(newDate,sum,length-1);
            sum.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,7,12,19};
        int k = 3;
        getWays(a,k);
    }
}
