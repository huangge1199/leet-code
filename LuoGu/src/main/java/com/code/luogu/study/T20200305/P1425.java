package com.code.luogu.study.T20200305;

import java.util.Scanner;

/**
 * @Author: hyy
 * @Date: 2020-03-05 00:17
 */

public class P1425 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int startH = in.nextInt();
        int startM = in.nextInt();
        int endH = in.nextInt();
        int endM = in.nextInt();
        int sub = endH * 60 + endM - startH * 60 - startM;
        System.out.println(sub / 60 + " " + sub % 60);
    }
}
