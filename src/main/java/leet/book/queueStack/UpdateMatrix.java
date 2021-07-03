package leet.book.queueStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 15:49
 * @Description: No Description
 */
public class UpdateMatrix {
    public static void main(String[] args) {
        Solution solution = new UpdateMatrix().new Solution();
    }

    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            Queue<int[]> queue = new LinkedList<>();
            int xLength = mat.length;
            int yLength = mat[0].length;
            boolean[][] use = new boolean[xLength][yLength];
            for (int i = 0; i < xLength; i++) {
                for (int j = 0; j < yLength; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        use[i][j] = true;
                    }
                }
            }
            int[][] ops = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int[] op : ops) {
                    int tx = x + op[0];
                    int ty = y + op[1];
                    if (tx >= 0 && tx < xLength && ty >= 0 && ty < yLength && !use[tx][ty]) {
                        mat[tx][ty] = mat[x][y] + 1;
                        queue.offer(new int[]{tx,ty});
                        use[tx][ty]=true;
                    }
                }
            }
            return mat;
        }
    }
}
