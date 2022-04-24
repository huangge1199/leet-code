package contest.y2022.m4.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/17 10:29
 */
public class Solution289 {

    public static void main(String[] args) {
        Solution289 solution = new Solution289();
        System.out.println(solution.longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
    }

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder tmp = new StringBuilder();
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                num += (s.charAt(i) - '0');
                if (i % k == k - 1) {
                    tmp.append(num);
                    num = 0;
                }
            }
            if (s.length() % k != 0) {
                tmp.append(num);
            }
            s = tmp.toString();
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            int nums = map.get(key);
            if (nums == 1) {
                return -1;
            }
            count += 0 == nums % 3 % 2 ? nums / 3 + nums % 3 / 2 : (nums / 3 - 1) + 2;
        }
        return count;
    }


    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < parent.length; i++) {
            map.get(parent[i]).add(i);
        }
        maxs = new int[parent.length];
        dfs(s, 0, map);
        int max = 1;
        for (int index : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (int num : map.get(index)) {
                if (s.charAt(index) != s.charAt(num)) {
                    list.add(maxs[num]);
                }
            }
            int size = list.size();
            int temp = 1;
            if (size > 1) {
                Collections.sort(list);
                temp += list.get(size - 1) + list.get(size - 2);
            } else if (size == 1) {
                temp += list.get(0);
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    int[] maxs;

    private int dfs(String s, int index, Map<Integer, List<Integer>> map) {
        int max = 1;
        for (int num : map.get(index)) {
            if (s.charAt(index) != s.charAt(num)) {
                max = Math.max(max, 1 + dfs(s, num, map));
            } else {
                dfs(s, num, map);
            }
        }
        maxs[index] = max;
        return max;
    }
}
