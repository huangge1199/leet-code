package com.code.lint.y2020.m02.d11;

/**
 * 1671. 玩游戏
 * <p>
 * N 个人在玩游戏，每局游戏有一个裁判和 N-1 个平民玩家。给出一个数组 A, A[i] 代表玩家 i 至少需要成为平民 A[i] 次，
 * 返回最少进行游戏的次数。
 *
 * @Author: hyy
 * @Date: 2020-02-11 13:38
 */

public class PlayGames {
    /**
     * @param A:
     * @return: nothing
     */
//    public static long playGames(int[] A) {
//        // Write your code here
//        long count = 0;
//        int num = 0;
//        int max = 0;
//        boolean bl = true;
//        do {
//            count = getCount(A, count);
//            num = 0;
//            max = 0;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] > count) {
//                    num++;
//                    if (A[i] - count > max) {
//                        max = (int) (A[i] - count);
//                    }
//                } else {
//                    bl = false;
//                }
//                A[i] = (int) (A[i] - count < 0 ? 0 : A[i] - count);
//            }
//        } while (num > 0 && bl);
//        return count + max;
//    }
//
//    public static long getCount(int[] A, long count) {
//        int sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            sum += A[i];
//        }
//        if (sum % (A.length - 1) == 0) {
//            count += sum / (A.length - 1);
//        } else {
//            count += sum / (A.length - 1) + 1;
//        }
//        return count;
//    }
    public static long playGames(int[] A) {
        long max = 0;
        for (int num : A) {
            if (num > max) {
                max = num;
            }
        }
        long start = 0;
        long end = max * 2;
        while (start < end) {
            long index = (start + end) / 2;
            long count = 0;
            for (int num : A) {
                if (index - num > 0) {
                    count += (index - num);
                }
            }
            if (index > count) {
                start = index + 1;
            } else {
                end = index;
            }
        }
        if (start > max) {
            max = start;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{39, 22, 89, 54, 91, 5, 30};
        System.out.println(playGames(nums));
    }
}
