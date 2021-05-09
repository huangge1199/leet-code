package com.code.leet.week;

import java.util.Arrays;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/5/9 10:25
 * @Description:
 */
public class Solution240 {
    public static void main(String[] args) {
        Solution240 solution = new Solution240();
//        System.out.println(solution.maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
//        System.out.println(solution.maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
//        System.out.println(solution.maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1}));
//        System.out.println(solution.maxDistance(
//                new int[]{7961, 7104, 6380, 6271, 6189, 5112, 5029, 2645, 2544, 1679, 1662, 1211, 996},
//                new int[]{9957, 9773, 9704, 9666, 9371, 9360, 9280, 9255, 9117, 9103, 8935, 8882, 8679, 8610, 8339}
//        ));
//        System.out.println(solution.maxDistance(
//                new int[]{9914, 9434, 8808, 8041, 7548, 6727, 5637, 4635, 2937, 607, 384, 335},
//                new int[]{9980, 9826, 9620, 9600, 9455, 9448, 9374, 9367, 9278, 9251, 9083, 8987, 8952, 8932, 8762, 8705, 8595, 8460}
//        ));
    }

    public int maximumPopulation(int[][] logs) {
        int[] year = new int[100];
        for (int[] log : logs) {
            for (int j = log[0]; j < log[1]; j++) {
                year[j - 1950]++;
            }
        }
        int index = 0;
        for (int i = 0; i < 100; i++) {
            if (year[i] > year[index]) {
                index = i;
            }
        }
        return index + 1950;
    }

    public int maxDistance(int[] nums1, int[] nums2) {
//        int index2 = nums2.length / 2;
//        int index1;
//        if (nums1.length > nums2.length) {
//            index1 = index2 - 1;
//        } else {
//            index1 = nums1.length / 2;
//        }
//        while (index1 >= 0 && index2 < nums2.length) {
//            while (nums1[index1] > nums2[index2]) {
//                index1++;
//                index2--;
//                if (index1 >= index2) {
//                    return 0;
//                }
//            }
//            if (nums1[index1] <= nums2[index2]) {
//                if (index1 > 0 && index2 + 1 < nums2.length && nums1[index1 - 1] <= nums2[index2 + 1]) {
//                    index1--;
//                    index2++;
//                } else if (index1 == 0 && index2 == nums2.length - 1) {
//                    break;
//                } else if ((index1 > 0 && nums1[index1 - 1] > nums2[index2]) && (index2 + 1 < nums2.length && nums1[index1] > nums2[index2 + 1])) {
//                    break;
//                } else if (index1 == 0 && index2 + 1 < nums2.length && nums1[index1] > nums2[index2 + 1]) {
//                    break;
//                } else if (index2 == nums2.length - 1 && index1 > 0 && nums1[index1 - 1] > nums2[index2]) {
//                    break;
//                } else if (index1 == 0 || nums1[index1 - 1] > nums2[index2]) {
//                    index2++;
//                } else if (index2 == nums2.length - 1 || nums1[index1] > nums2[index2 + 1]) {
//                    index1--;
//                }
//            }
//        }
//        return index2 - index1;
        int index1 = 0;
        int count = 0;
        boolean isCount = true;
        for (int i = nums2.length - 1; i > 0; i--) {
            while (nums1[index1] > nums2[i]) {
                if (index1 == nums1.length - 1) {
                    index1 = 0;
                    isCount = false;
                    break;
                }
                if (index1 > i) {
                    break;
                }
                index1++;
            }
            if (isCount) {
                count = Math.max(count, i - index1);
            } else {
                isCount = true;
            }
        }
        return count;
    }

    public int maxSumMinProduct(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long max = Integer.MIN_VALUE;
        int index = -1;
        for (int num : nums) {
            if (index == -1) {
                max = sum * num;
            } else {
                if (num != nums[index]) {
                    max = Math.max(sum * num, max);
                }
            }
            sum -= num;
            index++;
        }
        return (int) (max % (Math.pow(10, 9) + 7));
    }
}
