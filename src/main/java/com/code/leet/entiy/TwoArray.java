package com.code.leet.entiy;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/30 14:06
 * @Description: No Description
 */
@Data
public class TwoArray {

    int[][] arr;

    public TwoArray(String str, boolean bl) {
        if (bl) {
            getSquArr(str);
        } else {
            getArr(str);
        }
    }

    private void getSquArr(String str) {
        int xLength = str.length() - str.replace("[", "").length() - 1;
        int yLength = (str.length() - str.replace(",", "").length() - xLength + 1) / xLength + 1;
        arr = new int[xLength][yLength];
        int xIndex = 0;
        int yIndex = 0;
        String iStr = "";
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                iStr += ch;
            } else {
                if (!iStr.equals("")) {
                    arr[xIndex][yIndex] = Integer.parseInt(iStr);
                    iStr = "";
                    yIndex += 1;
                    if (yIndex == yLength) {
                        yIndex = 0;
                        xIndex += 1;
                    }
                }
            }
        }
    }

    private void getArr(String str) {
        str = str.substring(2, str.length() - 2);
        String[] strings = str.split("],\\[");
        arr = new int[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            if("".equals(strings[i])){
                arr[i] = new int[0];
                continue;
            }
            String[] strs = strings[i].split(",");
            arr[i] = new int[strs.length];
            for (int j = 0; j < strs.length; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }
    }
}
