package com.code.war.study.t20200213;

import java.util.ArrayList;
import java.util.List;

/**
 * 4 kyu
 * Sum of Intervals
 *
 * @Author: hyy
 * @Date: 2020-02-13 22:07
 */

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (list.size() > 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    List<Integer> temp = list.get(j);
                    if (start >= temp.get(0) && end <= temp.get(1)) {
                        list.remove(j);
                        start = temp.get(0);
                        end = temp.get(1);
                        break;
                    } else if (start >= temp.get(0) && start <= temp.get(1) && end >= temp.get(1)) {
                        start = temp.get(0);
                        list.remove(j);
                        j = list.size();
                    } else if (start <= temp.get(0) && end <= temp.get(1) && end >= temp.get(0)) {
                        end = temp.get(1);
                        list.remove(j);
                        j = list.size();
                    } else if (start <= temp.get(0) && end >= temp.get(1)) {
                        list.remove(j);
                    }
                }
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(end);
            list.add(temp);
        }
        int sum = 0;
        for (List<Integer> temp : list) {
            sum += temp.get(1) - temp.get(0);
        }
        return sum;
    }
}
