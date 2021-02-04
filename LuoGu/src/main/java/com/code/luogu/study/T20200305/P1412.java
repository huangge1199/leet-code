package com.code.luogu.study.T20200305;

import java.util.Scanner;

/**
 * @Author: hyy
 * @Date: 2020-03-05 00:07
 */

public class P1412 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num = (num1 * 10 + num2) / 19;
        System.out.println(num);
    }
}
