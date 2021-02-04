package com.code.luogu.study.T20200305;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: hyy
 * @Date: 2020-03-05 01:21
 */

public class P1422 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int battery = in.nextInt();
        float fee = 0;
        if(battery<=150){
            fee = 0.4463f*battery;
        }else if(battery<=400){
            fee = 0.4463f*150+(battery-150)*0.4663f;
        }else{
            fee=0.4463f*150+0.4663f*250+(battery-400)*0.5663f;
        }
        System.out.println(new DecimalFormat("0.0").format(fee));
    }
}
