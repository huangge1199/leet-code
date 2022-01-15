package contest.y2022.m1.week;


import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution275 {
    public static void main(String[] args) {
        Solution275 solution = new Solution275();
    }

    public boolean checkValid(int[][] matrix) {
        int[][] yarrs = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] arrs = Arrays.copyOf(matrix[i],matrix[0].length);
            Arrays.sort(arrs);
            if(arrs[0]!=1||arrs[matrix.length-1]!= matrix.length){
                return false;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                yarrs[j][i]=matrix[i][j];
            }
            for (int j = 0; j < arrs.length; j++) {
                if(arrs[j]!=j+1){
                    return false;
                }
            }
        }
        for (int i = 0; i < yarrs[0].length; i++) {
            int[] arrs = Arrays.copyOf(yarrs[i],yarrs[0].length);
            Arrays.sort(arrs);
            if(arrs[0]!=1||arrs[yarrs.length-1]!= yarrs.length){
                return false;
            }
            for (int j = 0; j < arrs.length; j++) {
                if(arrs[j]!=j+1){
                    return false;
                }
            }
        }
        return true;
    }
}
