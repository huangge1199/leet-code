package leet.book.contest.contest4;

import javafx.util.Pair;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }

    public int countIslands(int[][] grid) {
        boolean[][] use = new boolean[grid.length][grid[0].length];
        int count = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!use[i][j]){
                    continue;
                }
                use[i][j] = true;
                if (grid[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                    use[i][j] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> pair = queue.poll();
                        for (int k = -1; k < 2; k++) {
                            for (int l = -1; l < 2; l++) {
                                if (k == 0 && l == 0) {
                                    continue;
                                }
                                int x = k + pair.getKey();
                                int y = l + pair.getValue();
                                if (x < 0 || x >= grid.length || y < 0 || y > grid[0].length || use[x][y]) {
                                    continue;
                                }
                                use[x][y] = true;
                                if (grid[x][y] == 1) {
                                    queue.add(new Pair<>(x,y));
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
