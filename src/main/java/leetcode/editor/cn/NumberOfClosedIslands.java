//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。 
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。 
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。 
//
// 请返回封闭岛屿的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1
//,0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 83 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

//1254:统计封闭岛屿的数目
public class NumberOfClosedIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NumberOfClosedIslands().new Solution();
        TwoArray twoArray = new TwoArray("" +
                "[[1,1,1,1,1,1,1,0]," +
                "[1,0,0,0,0,1,1,0]," +
                "[1,0,1,0,1,1,1,0]," +
                "[1,0,0,0,0,1,0,1]," +
                "[1,1,1,1,1,1,1,0]]",true
        );
        System.out.println(solution.closedIsland(twoArray.getArr()));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] use;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int count = 0;
        boolean flag;

        public int closedIsland(int[][] grid) {
            use = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0 && !use[i][j]) {
                        flag = true;
                        dfs(i, j, grid);
                        if (flag) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private void dfs(int x, int y, int[][] grid) {
            use[x][y] = true;
            for (int i = 0; i < 4; i++) {
                x += dx[i];
                y += dy[i];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                    x -= dx[i];
                    y -= dy[i];
                    flag = false;
                    continue;
                }
                if (grid[x][y] == 0 && !use[x][y]) {
                    dfs(x, y, grid);
                }
                x -= dx[i];
                y -= dy[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}