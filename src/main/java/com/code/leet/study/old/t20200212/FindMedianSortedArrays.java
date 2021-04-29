package com.code.leet.study.old.t20200212;

import java.util.Arrays;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * @Author: hyy
 * @Date: 2020-02-12 22:44
 */

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = Arrays.copyOf(nums1,nums1.length+nums2.length);
        System.arraycopy(nums2,0,result,nums1.length,nums2.length);
        Arrays.sort(result);
        double num;
        int length = result.length;
        if(length%2==0){
            num = (result[length/2-1]+result[length/2])/2.0;
        }else{
            num = result[length/2];
        }
        return num;
    }
}
