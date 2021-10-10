package com.code.leet.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/10/10-11:53
 */
class StockPrice {

    Map<Integer, Integer> map;
    int max;
    int min;
    int cur;
    int price;

    public StockPrice() {
        map = new HashMap<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        cur = 0;
    }

    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        if (timestamp >= cur) {
            this.price = price;
        }
        max = price;
        min = price;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
            min = Math.min(min, map.get(key));
        }
    }

    public int current() {
        return price;
    }

    public int maximum() {
        return max;
    }

    public int minimum() {
        return min;
    }
}
