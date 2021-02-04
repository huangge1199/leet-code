package com.code.lint.y2020.m01.d26;

/**
 * @Author: hyy
 * @Date: 2020-01-26 01:32
 */

public class Depress {
    /**
     * @param m: the limit
     * @param k: the sum of choose
     * @param arr: the array
     * @return: yes or no
     */
    public String depress(int m, int k, int[] arr) {
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        int sum=0;
        for (int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum<m){
            return "yes";
        }else{
            return "no";
        }
    }
}
