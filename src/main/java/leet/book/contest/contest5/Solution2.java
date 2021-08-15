package leet.book.contest.contest5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solve(new String[]{"XSXX", "X...", "XX..", "EX.."}));
    }

    public int solve(String[] maze) {
        char[][] chs = new char[maze.length][maze[0].length()];
        int[][] use = new int[maze.length][maze[0].length()];
        for (int[] ints : use) {
            Arrays.fill(ints, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < maze.length; i++) {
            String str = maze[i];
            chs[i] = str.toCharArray();
            int index = str.indexOf("S");
            if (index >= 0) {
                queue.add(new int[]{i, index, 0});
                use[i][index] = 0;
            }
        }

        int[] xArr = new int[]{-1, 1, 0, 0};
        int[] yArr = new int[]{0, 0, -1, 1};

        int ex = 0;
        int ey = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = arr[0] + xArr[i];
                int y = arr[1] + yArr[i];
                if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length()) {
                    continue;
                }
                int temp = arr[2] + (chs[arr[0]][arr[1]] == 'X' ? 1 : 0);
                if (use[x][y] == -1 || use[x][y] > arr[2]) {
                    use[x][y] = temp;
                    if (chs[x][y] != 'E') {
                        queue.add(new int[]{x, y, temp});
                    } else {
                        ex = x;
                        ey = y;
                    }
                }
            }
        }
        return use[ex][ey];
    }
}
