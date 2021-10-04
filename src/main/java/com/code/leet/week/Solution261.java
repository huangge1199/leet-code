package com.code.leet.week;


import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution261 {
    public static void main(String[] args) {
        Solution261 solution = new Solution261();
//        System.out.println(solution.smallestSubsequence("leet",3,'e',1));
    }

    public int minimumMoves(String s) {
        int bef = -3;
        int index = s.indexOf("X");
        char[] chs = s.toCharArray();
        int count = 0;
        while (index >= 0) {
            count++;
            bef += index + 3;
            chs[bef] = 'O';
            if (bef + 1 < chs.length) {
                chs[bef + 1] = 'O';
            } else {
                break;
            }
            if (bef + 2 < chs.length) {
                chs[bef + 2] = 'O';
            } else {
                break;
            }
            if (bef + 3 < chs.length) {
                s = s.substring(index + 3);
                index = s.indexOf("X");
            } else {
                break;
            }
        }
        return count;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        int avg = sum / n;
        int mod = sum % n;
        if (avg + (mod == 0 ? 0 : 1) > 6 || avg + (mod == 0 ? 0 : 1) <= 0) {
            return new int[]{};
        }
        int[] arrs = new int[n];
        Arrays.fill(arrs, avg);
        for (int i = 0; i < mod; i++) {
            arrs[i]++;
        }
        return arrs;
    }

//    public boolean stoneGameIX(int[] stones) {
//        int sum = 0;
//        int count = 0;
//        for (int stone : stones) {
//            sum += stone;
//            if (stone % 3 > 0) {
//                count++;
//            }
//        }
//        return sum % 3 == 0 && stones.length % 2 == 0 && count > 0;
//        int[] arrs = new int[3];
//        for (int stone : stones) {
//            arrs[stone % 3]++;
//        }
//    }

//    public String smallestSubsequence(String s, int k, char letter, int repetition) {
//        List<Integer> list = new ArrayList<>();
//        int count = 0;
//        int i = 0;
//        for (; i < s.length() - 1; i++) {
//            if (s.charAt(i) > s.charAt(i + 1)) {
//                list.add(i);
//                if (s.length() - k == list.size()) {
//                    break;
//                }
//            } else if (s.charAt(i) == letter) {
//                count++;
//            }
//        }
//        s = s.substring(0, i + 1);
//        int temp = repetition - count;
//        for (int j = 0; j < temp; j++) {
//            s += letter;
//            while (list.contains(i)) {
//                i--;
//            }
//            list.add(i);
//            i--;
//        }
//        Collections.sort(list);
//        char[] chs = s.toCharArray();
//        s = "";
//        int index = 0;
//        StringBuilder sBuilder = new StringBuilder(s);
//        for (int j = 0; j < chs.length; j++) {
//            if (j < list.get(index)) {
//                sBuilder.append(chs[j]);
//            } else {
//                index++;
//            }
//        }
//        s = sBuilder.toString();
//        return s;
//    }
}
