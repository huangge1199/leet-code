package com.code.lint.y2020.m02.d11;

import java.util.Arrays;

/**
 * @Author: hyy
 * @Date: 2020-02-11 23:36
 */

/**
 * 945 任务计划
 */
public class LeastInterval {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n:     the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public static int leastInterval(char[] tasks, int n) {
        // write your code here
        int[] ch = new int[26];
        for(char c : tasks){
            ch[c-'A']++;
        }
        Arrays.sort(ch);
        int i = 25;
        while (i>=0 && ch[i]==ch[25]){
            i--;
        }
        return Math.max(tasks.length, (ch[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        String str = "BFJJCHICEGCEJFGJBIBBCBGAJHCGDEHEHAHIAJCGBGHGH";
        char[] tasks = str.toCharArray();
//        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 15;
        System.out.println(leastInterval(tasks, n));
    }
}
