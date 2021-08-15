package leet.book.contest.contest4;

import javafx.util.Pair;

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
    }

    public int getDistance(int[][] grid) {
        int[] xI = new int[]{-1, 1, 0, 0};
        int[] yIndex = new int[]{0, 0, -1, 1};
        Queue<Pair<Integer, Integer>> load = new LinkedList<>();
        boolean[][] use = new boolean[grid.length][grid[0].length];
        boolean bl = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !use[i][j]) {
                    bl = true;
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.add(new Pair<>(i, j));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> pair = queue.poll();
                        load.add(new Pair<>(pair.getKey(), pair.getValue()));
                        for (int k = 0; k < 4; k++) {
                            int x = pair.getKey() + xI[k];
                            int y = pair.getValue() + yIndex[k];
                            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || use[x][y]) {
                                continue;
                            }
                            if (grid[x][y] == 1) {
                                queue.add(new Pair<>(x, y));
                                use[x][y] = true;
                            }
                        }
                    }
                    break;
                }
            }
            if (bl) {
                break;
            }
        }
        int count = 0;
        while (!load.isEmpty()) {
            int size = load.size();
            count++;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = load.poll();
                for (int k = 0; k < 4; k++) {
                    int x = pair.getKey() + xI[k];
                    int y = pair.getValue() + yIndex[k];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || use[x][y]) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return count;
                    }
                    load.add(new Pair<>(x, y));
                    use[x][y] = true;
                }
            }
        }
        return 0;
    }
}
