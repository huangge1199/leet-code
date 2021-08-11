//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 274 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//417:太平洋大西洋水流问题
class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {// 用来返回的返回值
        private final List<List<Integer>> ans = new ArrayList<>();
        // 方向转换的数组
        private final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        // 大西洋和太平洋共享的访问数组
        private boolean[][] visited = null;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int n = heights.length, m = heights[0].length;
            visited = new boolean[n][m];
            // temp 是用来记录当前深度优先搜索访问过的点
            boolean[][] temp = new boolean[n][m];
            // 首先从太平洋出发，看看都能遇到哪些点
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    // x == 0 || y == 0 表示要从太平洋出发需要满足的条件，flag == false 意味着是从太平洋出发的
                    if ((x == 0 || y == 0) && !temp[x][y]) dfs(heights, x, y, temp, n, m, false);
                }
            }
            // 同上，temp 是用来标记当前深度优先搜索访问到的点
            temp = new boolean[n][m];
            // 然后再从大西洋出发，看看能遇到哪些点，如果遇到的点 在 visited 中之前已经被标记为 true， 那么说明双方都可到达
            for (int x = 0; x < n; ++x) {
                for (int y = 0; y < m; ++y) {
                    // x == n - 1 || y == m - 1 表示从大西洋出发
                    if ((x == n - 1 || y == m - 1) && !temp[x][y]) dfs(heights, x, y, temp, n, m, true);
                }
            }
            return ans;
        }

        /**
         * @param x    深度优先搜索的起始点坐标 x
         * @param y    起始点坐标 y
         * @param temp 用来标记当前深度优先搜索已经访问过哪些点了
         * @param flag 为 true 时意味着是大西洋来的，为 false 意味着是太平洋来的
         */
        private void dfs(int[][] heights, int x, int y, boolean[][] temp, int n, int m, boolean flag) {
            // 如果是大西洋来的，而且 太平洋已经访问过 {x, y} 了，就放到返回值中
            if (flag && visited[x][y]) {
                List<Integer> buf = new ArrayList<>();
                buf.add(x);
                buf.add(y);
                ans.add(buf);
                // 顺便把该点置为 false，防止重复记录
                visited[x][y] = false;
            }
            // 如果是从太平洋来的，需要将 {x, y} 标记为已来过
            if (!flag) visited[x][y] = true;
            // 然后切换四个方向，逐个检查
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                // 检查新的坐标是否合法，以及当前深度优先搜索是否来过，最后还要满足 逆向 条件
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !temp[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    temp[nx][ny] = true;    // 然后在当前深度优先搜索中标记为已来过
                    dfs(heights, nx, ny, temp, n, m, flag); // 继续深度优先搜索
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}