//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 103 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.LinkedList;
import java.util.Queue;

//1020:飞地的数量
class NumberOfEnclaves {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NumberOfEnclaves().new Solution();
        TwoArray twoArray = new TwoArray("[[0],[1],[1],[0],[0]]", true);
        solution.numEnclaves(twoArray.getArr());
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEnclaves(int[][] grid) {
            boolean[][] use = new boolean[grid.length][grid[0].length];
            Queue<int[]> queue = new LinkedList<>();
            int xl = grid.length;
            int yl = grid[0].length;
            int count = 0;
            for (int i = 0; i < xl; i++) {
                if (grid[i][0] == 1) {
                    queue.add(new int[]{i, 0});
                    use[i][0] = true;
                    count++;
                }
                if (grid[i][yl - 1] == 1 && !use[i][yl - 1]) {
                    queue.add(new int[]{i, yl - 1});
                    use[i][yl - 1] = true;
                    count++;
                }
            }
            for (int i = 1; i < yl - 1; i++) {
                if (grid[0][i] == 1 && !use[0][i]) {
                    queue.add(new int[]{0, i});
                    use[0][i] = true;
                    count++;
                }
                if (grid[xl - 1][i] == 1 && !use[xl - 1][i]) {
                    queue.add(new int[]{xl - 1, i});
                    use[xl - 1][i] = true;
                    count++;
                }
            }
            int[] xp = new int[]{1, -1, 0, 0};
            int[] yp = new int[]{0, 0, 1, -1};
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int x = arr[0];
                int y = arr[1];
                for (int k = 0; k < 4; k++) {
                    int nx = x + xp[k];
                    int ny = y + yp[k];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1 && !use[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        use[nx][ny] = true;
                        count++;
                    }
                }
            }
            int sum = 0;
            for (int[] ints : grid) {
                for (int j = 0; j < yl; j++) {
                    if (ints[j] == 1) {
                        sum++;
                    }
                }
            }
            return sum - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}