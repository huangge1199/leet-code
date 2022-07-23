package contest.y2022.m7;

import java.util.*;

public class NumberContainers {
    Map<Integer, Integer> nums;
    Map<Integer, TreeSet<Integer>> map;

    public NumberContainers() {
        nums = new HashMap<>();
        map = new HashMap<>();
    }

    public void change(int index, int number) {
        if (nums.containsKey(index)) {
            map.get(nums.get(index)).remove(index);
        }
        nums.put(index, number);
        TreeSet<Integer> list = map.getOrDefault(number, new TreeSet<>());
        list.add(index);
        map.put(number, list);
    }

    public int find(int number) {
        TreeSet<Integer> list = map.getOrDefault(number, new TreeSet<>());
        if (list.size() > 0) {
            return list.first();
        } else {
            return -1;
        }
    }
}
