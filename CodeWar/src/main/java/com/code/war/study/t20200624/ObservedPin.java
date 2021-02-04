package com.code.war.study.t20200624;

import java.util.*;

/**
 * @Author: hyy
 * @Date: 2020-06-24 14:16
 */

public class ObservedPin {

    public static List<String> getPINs(String observed) {
        Map<String,List<String>> map = new HashMap<>(10);
        map.put("1", Arrays.asList("1","2","4"));
        map.put("2",Arrays.asList("1","5","2","3"));
        map.put("3", Arrays.asList("5","6","3"));
        map.put("4",Arrays.asList("1","5","7","4"));
        map.put("5",Arrays.asList("2","4","6","8","5"));
        map.put("6",Arrays.asList("3","5","9","6"));
        map.put("7", Arrays.asList("4","8", "7"));
        map.put("8",Arrays.asList("5", "7", "8", "9", "0"));
        map.put("9",Arrays.asList("6","8","9"));
        map.put("0", Arrays.asList("0","8"));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < observed.length(); i++) {
            List<String> pin = map.get(observed.substring(i,i+1));
            if(result.size()==0){
                for (int j = 0; j < pin.size(); j++) {
                    result.add(pin.get(j));
                }
            }else{
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < pin.size(); j++) {
                    for (int k = 0; k < result.size(); k++) {
                        temp.add(result.get(k)+pin.get(j));
                    }
                }
                result = temp;
            }
        }
        return result;
    }
}
