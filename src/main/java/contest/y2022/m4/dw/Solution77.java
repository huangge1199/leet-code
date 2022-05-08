package contest.y2022.m4.dw;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/30 22:28
 */
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        TwoArray grid = new TwoArray("[[0,0,0,0,0,0],[0,2,2,2,2,0],[0,0,0,1,2,0],[0,2,2,2,2,0],[0,0,0,0,0,0]]", true);
        solution.maximumMinutes(grid.getArr());
    }

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                count++;
            }
        }
        return count;
    }

    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int size = nums.length;
        long[] sums = new long[size + 1];
        for (int i = 0; i < size; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int min = 0;
        int index = 0;
        int tmp;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                tmp = (int) (sums[size] / size);
            } else {
                tmp = (int) Math.abs(sums[i + 1] / (i + 1) - (sums[size] - sums[i + 1]) / (size - i - 1));
            }
            if (i == 0 || tmp < min) {
                min = tmp;
                index = i;
            }
        }
        return index;
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        boolean[][] use = new boolean[m][n];
        int[][] arrs = new int[m][n];
        int count = m * n;
        for (int[] arr : walls) {
            arrs[arr[0]][arr[1]] = 1;
            count--;
        }
        for (int[] arr : guards) {
            arrs[arr[0]][arr[1]] = 1;
            count--;
        }
        for (int[] arr : guards) {
            for (int i = arr[0] - 1; i >= 0; i--) {
                if (arrs[i][arr[1]] == 1) {
                    break;
                }
                if (!use[i][arr[1]]) {
                    count--;
                    use[i][arr[1]] = true;
                }
            }
            for (int i = arr[0] + 1; i < m; i++) {
                if (arrs[i][arr[1]] == 1) {
                    break;
                }
                if (!use[i][arr[1]]) {
                    count--;
                    use[i][arr[1]] = true;
                }
            }
            for (int i = arr[1] - 1; i >= 0; i--) {
                if (arrs[arr[0]][i] == 1) {
                    break;
                }
                if (!use[arr[0]][i]) {
                    count--;
                    use[arr[0]][i] = true;
                }
            }
            for (int i = arr[1] + 1; i < n; i++) {
                if (arrs[arr[0]][i] == 1) {
                    break;
                }
                if (!use[arr[0]][i]) {
                    count--;
                    use[arr[0]][i] = true;
                }
            }
        }
        return count;
    }

    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] fires = getMins(grid, 1);
        int[][] mins = getMins(grid, 3);
        Queue<int[]> queue = new LinkedList<>();
        if (fires[0][0] - mins[0][0] <= 0) {
            return -1;
        }
        queue.add(new int[]{0, 0, fires[0][0] - mins[0][0]});
        boolean[][] uses = new boolean[m][n];
        uses[0][0] = true;
        int[] xt = new int[]{1, -1, 0, 0};
        int[] yt = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] arrs = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = arrs[0] + xt[i];
                int y = arrs[1] + yt[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !uses[x][y]) {
                    int step = fires[x][y] == 1000000000 ? 1000000000 : fires[x][y] - mins[x][y];
                    int min = Math.min(step, arrs[2]);
                    if (x == m - 1 && y == n - 1) {
                        return Math.min(step, arrs[2]);
                    }
                    if (min > 0) {
                        queue.add(new int[]{x, y, min});
                        uses[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    private int[][] getMins(int[][] grid, int type) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] arrs = new int[m][n];
        boolean[][] uses = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        if (type == 1) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(arrs[i], 1000000000);
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == type) {
                        queue.add(new Pair<>(i, j));
                        uses[i][j] = true;
                    }
                }
            }
        } else {
            queue.add(new Pair<>(0, 0));
            uses[0][0] = true;
        }
        int[] xt = {1, -1, 0, 0};
        int[] yt = {0, 0, 1, -1};
        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pair.getKey() + xt[j];
                    int y = pair.getValue() + yt[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !uses[x][y]) {
                        arrs[x][y] = min;
                        uses[x][y] = true;
                        queue.add(new Pair<>(x, y));
                    }
                }
            }
        }
        return arrs;
    }

}
