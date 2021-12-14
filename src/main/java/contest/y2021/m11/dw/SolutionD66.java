package contest.y2021.m11.dw;

import java.util.HashMap;
import java.util.Map;

public class SolutionD66 {
    public static void main(String[] args) {
        SolutionD66 solution = new SolutionD66();
//        System.out.println(solution.minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
//        System.out.println(solution.minCost(new int[]{2, 0}, new int[]{2, 2}, new int[]{8,5,6,12,10}, new int[]{1,8,18,11,24,16}));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                map.put(key, 0);
            }
        }
        for (String str : words2) {
            map.put(str, map.getOrDefault(str, 0) - 1);
        }
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 0) {
                count++;
            }
        }
        return count;
    }

    public int minimumBuckets(String street) {
        if (!street.contains("H")) {
            return 0;
        }
        if (street.contains("HHH") || street.lastIndexOf("HH") == street.length() - 2 || street.indexOf("HH") == 0) {
            return -1;
        }
        int count = 0;
        char[] chs = street.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '.') {
                continue;
            } else if (chs[i] == 'B') {
                continue;
            } else if (i > 0 && chs[i - 1] == 'B') {
                continue;
            } else {
                count++;
                if (i < chs.length - 1 && chs[i + 1] == '.') {
                    chs[i + 1] = 'B';
                }
            }
        }
        return count;
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int row = Integer.compare(homePos[0], startPos[0]);
        int col = Integer.compare(homePos[1], startPos[1]);
        if (row == 0 && col == 0) {
            return 0;
        }
        int sum = 0;
        if (row == 1) {
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
                sum += rowCosts[i];
            }
        } else if (row == -1) {
            for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
                sum += rowCosts[i];
            }
        }
        if (col == 1) {
            for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
                sum += colCosts[i];
            }
        } else if (col == -1) {
            for (int i = startPos[1] - 1; i >= homePos[1]; i--) {
                sum += colCosts[i];
            }
        }
        return sum;
    }
}
