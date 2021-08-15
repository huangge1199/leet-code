package leet.book.contest.contest6;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        TwoArray twoArray = new TwoArray("[[0,2,0,0,0],[2,2,2,0,0],[3,2,0,1,1],[3,3,3,1,0],[3,3,3,3,0]]", true);
        System.out.println(solution.miniumDistance(twoArray.getArr()));
    }

    public int miniumDistance(int[][] grid) {
        Map<Pair<Integer, Integer>, boolean[]> map = new HashMap<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] xindex = new int[]{-1, 1, 0, 0};
        int[] yindex = new int[]{0, 0, -1, 1};
        boolean[][] use = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Pair<>(i, j));
                    use[i][j] = true;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pair.getKey() + xindex[j];
                    int y = pair.getValue() + yindex[j];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || use[x][y]) {
                        continue;
                    }
                    Pair<Integer, Integer> add = new Pair<>(x, y);
                    boolean[] arr = map.getOrDefault(add, new boolean[3]);
                    arr[grid[x][y] - 1] = true;
                    if (arr[0] && arr[1] && arr[2]) {
                        return count;
                    }
                    map.put(add,arr);
                    use[x][y] = true;
                    queue.add(add);
                }
            }
        }
        return 0;
    }
}
