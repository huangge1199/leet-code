package com.code.leet.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution259 {
    public static void main(String[] args) {
        Solution259 solution = new Solution259();
    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String str : operations) {
            if (str.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public int sumOfBeauties(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        boolean[] bef = new boolean[nums.length];
        boolean[] aft = new boolean[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            bef[i] = nums[i] > max;
            aft[nums.length - 1 - i] = nums[nums.length - 1 - i] < min;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - 1 - i]);
        }
        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (bef[i] && aft[i]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }
        return sum;
    }

    class DetectSquares {

        Map<Integer, List<Integer>> map;
        int[][] counts;

        public DetectSquares() {
            map = new HashMap<>();
            counts = new int[1001][1001];
        }

        public void add(int[] point) {
            List<Integer> list = map.getOrDefault(point[0], new ArrayList<>());
            if (!list.contains(point[1])) {
                list.add(point[1]);
                map.put(point[0], list);
            }
            counts[point[0]][point[1]]++;
        }

        public int count(int[] point) {
            if (!map.containsKey(point[0])) {
                return 0;
            }
            List<Integer> list = map.get(point[0]);
            int sum = 0;
            for (Integer integer : list) {
                if (point[1] == integer) {
                    continue;
                }
                int[] sxs = new int[]{point[0] - Math.abs(point[1] - integer), point[0] + Math.abs(point[1] - integer)};
                for (int sx : sxs) {
                    if (sx >= 0 && sx <= 1000) {
                        if (!map.containsKey(sx)) {
                            continue;
                        }
                        List<Integer> list1 = map.get(sx);
                        if (list1.contains(point[1]) && list1.contains(integer)) {
                            sum += counts[point[0]][integer] * counts[sx][point[1]] * counts[sx][integer];
                        }
                    }
                }
            }
            return sum;
        }
    }

//    public String longestSubsequenceRepeatedK(String s, int k) {
//        Map<Character, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
//            list.add(i);
//            map.put(s.charAt(i), list);
//        }
//        for (char ch : map.keySet()) {
//            if (map.get(ch).size() < k) {
//                s = s.replace("" + ch, "");
//            }
//        }
//        return null;
//    }
}
