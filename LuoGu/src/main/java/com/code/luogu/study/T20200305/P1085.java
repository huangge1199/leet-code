package com.code.luogu.study.T20200305;

import java.util.Scanner;

/**
 * @Author: hyy
 * @Date: 2020-03-05 01:31
 */

public class P1085 {
    public static void main(String[] args) {
        int greet = 0;
        int max = 8;
        int[][] hours = new int[7][2];
        for (int i = 0; i < 7; i++) {
            Scanner in = new Scanner(System.in);
            hours[i][0] = in.nextInt();
            hours[i][1] = in.nextInt();
        }
        for (int i = 0; i < 7; i++) {
            if (hours[i][0] + hours[i][1] > max) {
                max = hours[i][0] + hours[i][1];
                greet = i + 1;
            }
        }
        System.out.println(greet);
    }
}
