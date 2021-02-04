package com.code.lint.y2020.m01.d25;

/**
 * @Author: hyy
 * @Date: 2020-01-25 22:40
 */

public class MultiSort {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public static int[][] multiSort(int[][] array) {
        // Write your code here
        for (int i = 0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i][1]<array[j][1]){
                    int[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }else if(array[i][1]==array[j][1]){
                    if(array[i][0]>array[j][0]){
                        int[] temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{7,66},{4,77},{3,63},{5,81},{1,88},{9,86},{6,88},{2,82},{8,55},{10,95}};
        array = multiSort(array);
        System.out.println(array.toString());
    }
}
