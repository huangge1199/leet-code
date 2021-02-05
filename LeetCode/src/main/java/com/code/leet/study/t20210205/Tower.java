package com.code.leet.study.t20210205;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tower {
    public static void tower(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("第" + n + "号盘从" + a + "移到" + c);
        } else {
            tower(n - 1, a, c, b);
            System.out.println(n + ":" + a + "-->" + c);
            tower(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        int num = 1;
        List<Integer> a = new ArrayList<>(num);
        List<Integer> b = new ArrayList<>(num);
        List<Integer> c = new ArrayList<>(num);
        for (int i = 1; i <= num; i++) {
            a.add(i);
        }
        Map<String, List<Integer>> map = new HashMap<>(3);
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        tower(num, "a", "b", "c");
    }
}
