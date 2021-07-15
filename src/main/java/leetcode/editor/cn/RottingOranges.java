//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 382 👎 0

package leetcode.editor.cn;

import java.util.*;

//994:腐烂的橘子
public class RottingOranges {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RottingOranges().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    } else if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                return 0;
            }

            List<int[]> list = Arrays.asList(
                    new int[]{-1, 0},
                    new int[]{1, 0},
                    new int[]{0, -1},
                    new int[]{0, 1}
            );
            int[][] is = new int[grid.length][grid[0].length];
            int time = -1;
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                for (int[] point : list) {
                    int x = arr[0] + point[0];
                    int y = arr[1] + point[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }
                    is[x][y] = is[arr[0]][arr[1]] + 1;
                    time = Math.max(time, is[x][y]);
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    count--;
                }
            }
            return count > 0 ? -1 : time;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}