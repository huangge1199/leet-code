package com.code.lint.y2020.m01.d25;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hyy
 * @Date: 2020-01-25 21:59
 */

public class MostFrequentlyAppearingLetters {

    /**
     * @param str: the str
     * @return: the sum that the letter appears the most
     */
    public int mostFrequentlyAppearingLetters(String str) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0 ;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
                if(map.get(str.charAt(i))>max){
                    max = map.get(str.charAt(i));
                }
            }else{
                map.put(str.charAt(i),1);
            }
        }
        return max;
    }
}
