package leet.book.contest.contest5;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
    }

    public int getDistance(String[] maze) {
        int[] xIndex = new int[]{-1, 1, 0, 0};
        int[] yIndex = new int[]{0, 0, -1, 1};
        char[][] chs = new char[maze.length][maze[0].length()];
        for (int i = 0; i < maze.length; i++) {
            chs[i] = maze[i].toCharArray();
        }
        boolean[][] use = new boolean[maze.length][maze[0].length()];
        Pair<Integer, Integer> start = null;
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < chs[0].length; j++) {
                if (chs[i][j] == 'X') {
                    use[i][j] = true;
                }
                if (chs[i][j] == 'S') {
                    use[i][j] = true;
                    start = new Pair<>(i, j);
                }
            }
        }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pair.getKey() + xIndex[j];
                    int y = pair.getValue() + yIndex[j];
                    if (x < 0 || x >= chs.length || y < 0 || y >= chs[0].length || use[x][y]) {
                        continue;
                    }
                    if (chs[x][y] == '.') {
                        queue.add(new Pair<>(x, y));
                        use[x][y] = true;
                    }
                    if(chs[x][y]=='E'){
                        return count;
                    }
                }
            }
        }
        return -1;
    }
}
