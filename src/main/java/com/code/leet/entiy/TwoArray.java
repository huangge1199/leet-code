package com.code.leet.entiy;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public TwoArray(String str) {
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
}
