package com.code.war.study.t20200217;

/**
 * Scramblies
 *
 * @Author: hyy
 * @Date: 2020-02-17 09:55
 */

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        // your code
        boolean result = true;
        for (int i=0;i<str2.length();i++){
            int index = str1.indexOf(str2.substring(i,i+1));
            if(index>=0){
                str1 = str1.substring(0,index)+str1.substring(index+1);
            }else{
                result=false;
                break;
            }
        }
        return result;
    }
}
