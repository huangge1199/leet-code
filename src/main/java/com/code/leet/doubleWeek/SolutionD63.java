package com.code.leet.doubleWeek;

import java.util.*;

public class SolutionD63 {
    public static void main(String[] args) {
        SolutionD63 solution = new SolutionD63();
//        solution.networkBecomesIdle(new int[][]{{0,1},{1,2}},new int[]{0,2,1});
//        solution.networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10});
        solution.networkBecomesIdle(new int[][]{{5, 7}, {15, 18}, {12, 6}, {5, 1}, {11, 17}, {3, 9}, {6, 11}, {14, 7}, {19, 13}, {13, 3},
                        {4, 12}, {9, 15}, {2, 10}, {18, 4}, {5, 14}, {17, 5}, {16, 2}, {7, 1}, {0, 16}, {10, 19}, {1, 8}},
                new int[]{0, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1});
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }

    public boolean winnerOfGame(String colors) {
        int count = 0;
        for (int i = 2; i < colors.length(); i++) {
            if (colors.charAt(i - 2) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A') {
                count++;
            }
            if (colors.charAt(i - 2) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B') {
                count--;
            }
        }
        return count > 0;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int size = patience.length;
        int[] steps = new int[size];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> vals = map.get(0);
        int step = 1;
        for (Integer val : vals) {
            queue.add(val);
            steps[val] = step;
        }
        while (!queue.isEmpty()) {
            step++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int key = queue.poll();
                vals = map.get(key);
                for (Integer val : vals) {
                    if (steps[val] == 0) {
                        queue.add(val);
                        steps[val] = step;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i < size; i++) {
            max = Math.max(max, steps[i] * 2 + (steps[i] * 2 - 1) / patience[i] * patience[i]);
        }
        return max + 1;
    }
}
