package contest.y2021.m11.week;


import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution266 {
    public static void main(String[] args) {
        Solution266 solution = new Solution266();
//        TwoArray twoArray = new TwoArray("[[0,1,10],[1,2,11],[2,3,12],[1,3,13]]", true);
//        System.out.println(solution.maximalPathQuality(new int[]{1, 2, 3, 4}, twoArray.getArr(), 50));
        TwoArray twoArray = new TwoArray("[[0,1,10],[1,2,15],[0,3,10]]", true);
        System.out.println(solution.maximalPathQuality(new int[]{0, 32, 10, 43}, twoArray.getArr(), 49));
    }

    public int countVowelSubstrings(String word) {
        int sum = 0;
        char[] chs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            sum += dfs(chs, i, Arrays.asList('a', 'e', 'i', 'o', 'u'), 0, new int[5], 0);
        }
        return sum;
    }

    private int dfs(char[] chs, int index, List<Character> list, int sum, int[] arrs, int count) {
        if (index == chs.length) {
            return sum;
        }
        if (!list.contains(chs[index])) {
            return count == 5 ? sum : 0;
        }
        if (count < 5 && arrs[list.indexOf(chs[index])] == 0) {
            count++;
        }
        arrs[list.indexOf(chs[index])]++;
        if (count == 5) {
            sum += 1;
        }
        return dfs(chs, index + 1, list, sum, arrs, count);
    }

    public long countVowels(String word) {
        char[] chs = word.toCharArray();
        long sum = 0;
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < word.length(); i++) {
            if (list.contains(chs[i])) {
                sum += (long) (i + 1) * (chs.length - i);
            }
        }
        return sum;
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            List<int[]> list = map.get(edge[0]);
            list.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], list);
            list = map.get(edge[1]);
            list.add(new int[]{edge[0], edge[2]});
            map.put(edge[1], list);
        }
        max = values[0];
        int[] use = new int[values.length];
        use[0] = 1;
        pathDfs(map, values[0], use, maxTime, 0, 0, values);
        return max;
    }

    int max;

    private void pathDfs(Map<Integer, List<int[]>> map, int value, int[] use, int maxTime, int time, int index, int[] values) {
        List<int[]> list = map.get(index);
        for (int[] arr : list) {
            time += arr[1];
            if (time > maxTime) {
                time -= arr[1];
                continue;
            }
            if (arr[0] > 0 && use[arr[0]] == 2) {
                continue;
            }
            if (use[arr[0]] == 0) {
                value += values[arr[0]];
            }
            use[arr[0]]++;
            if (arr[0] == 0) {
                max = Math.max(value, max);
            }
            if (time == maxTime) {
                time -= arr[1];
                if (use[arr[0]] == 1) {
                    value -= values[arr[0]];
                }
                use[arr[0]]--;
                continue;
            }
            pathDfs(map, value, use, maxTime, time, arr[0], values);
            time -= arr[1];
            if (use[arr[0]] == 1) {
                value -= values[arr[0]];
            }
            use[arr[0]]--;
        }
    }
}
