package com.code.leet.week;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/3 22:33
 * @Description:
 */
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
//        System.out.println(solution.squareIsWhite("a1"));
    }

    public boolean squareIsWhite(String coordinates) {
        char[] chars = coordinates.toCharArray();
        if ((chars[0] - chars[1]) % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        sentence1 += " ";
        sentence2 += " ";
        String[] strs1 = sentence1.split(" ");
        String[] strs2 = sentence2.split(" ");
        int size1 = strs1.length;
        int size2 = strs2.length;
        if (size1 == size2) {
            return sentence1.equals(sentence2);
        } else if (size1 > size2) {
            return isTrue(strs1, strs2);
        } else {
            return isTrue(strs2, strs1);
        }
    }
    private boolean isTrue(String[] strs1, String[] strs2) {
        int size1 = strs1.length;
        int size2 = strs2.length;
        int index = 0;
        while (index < size2 && strs2[index].equals(strs1[index])) {
            index++;
        }
        if (index == size2) {
            return true;
        }
        for (int i = 1; i <= size2 - index; i++) {
            if (!strs2[size2 - i].equals(strs1[size1 - i])) {
                return false;
            }
        }
        return true;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            int key = num - revert(num);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, Long.parseLong("1"));
            }
        }
        long count = 0;
        for (int key : map.keySet()) {
            long value = map.get(key);
            if (value > 1) {
                count += value * (value - 1) / 2;
            }
        }
        return (int)(count % (Math.pow(10, 9) + 7));
    }
    private int revert(int num) {
        String str = "" + num;
        str = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(str);
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = groups.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (groups[i] % batchSize == 0) {
                count++;
            }
        }
        return 0;
    }
}
