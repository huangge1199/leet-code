//给你一个 m × n 的网格，值为 0 、 1 或 2 ，其中: 
//
// 
// 每一个 0 代表一块你可以自由通过的 空地 
// 每一个 1 代表一个你不能通过的 建筑 
// 每个 2 标记一个你不能通过的 障碍 
// 
//
// 你想要在一块空地上建造一所房子，在 最短的总旅行距离 内到达所有的建筑。你只能上下左右移动。 
//
// 返回到该房子的 最短旅行距离 。如果根据上述规则无法建造这样的房子，则返回 -1 。 
//
// 总旅行距离 是朋友们家到聚会地点的距离之和。 
//
// 使用 曼哈顿距离 计算距离，其中距离 (p1, p2) = |p2.x - p1.x | + | p2.y - p1.y | 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//输出：7 
//解析：给定三个建筑物 (0,0)、(0,4) 和 (2,2) 以及一个位于 (0,2) 的障碍物。
//由于总距离之和 3+3+1=7 最优，所以位置 (1,2) 是符合要求的最优地点。
//故返回7。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1,0]]
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: grid = [[1]]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 是 0, 1 或 2 
// grid 中 至少 有 一幢 建筑 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 118 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//317:离建筑物最近的距离
public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
        Solution solution = new ShortestDistanceFromAllBuildings().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int rows;
        private int cols;

        public int shortestDistance(int[][] grid) {
            if (null == grid || grid.length == 0) {
                return -1;
            }
            // 题目要找的是最合适的空地，我们可以转换为假如某空地A(x,y)，所有建筑物到A(x,y)的最短距离的总和，
            // 单个最短距离，可以采用BFS算法
            // 再在所有的空地最短距离中取最小距离。
            rows = grid.length;
            cols = grid[0].length;
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            //记录每一个建筑到空地的距离，每运算一次建筑到某空地的距离，该空地就累加一次距离和。
            int[][] dist = new int[rows][cols];
            int tallCount = 0;
            int[][] countCalc = new int[rows][cols];
            // distance[i][j]记录所有建筑物queue到某空地的最短距离
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {

                        ans = bfs(grid, new int[]{i, j, 0}, countCalc, dist, tallCount);
                        tallCount++;
                        //ans = Math.min(ans,temp);
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        // 计算每一个建筑tallPair到空地(x,y)的最短距离
        private int bfs(int[][] grid, int[] tallPair, int[][] countCalc, int[][] distance, int tallCount) {
            int[][] directors = new int[][]{
                    {0, 1}, {0, -1}, {-1, 0}, {1, 0}
            };
            int ans = Integer.MAX_VALUE;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(tallPair);
            while (!queue.isEmpty()) {
                int[] pair = queue.poll();
                int x = pair[0];
                int y = pair[1];
                int tempDistance = pair[2];
                for (int i = 0; i < directors.length; i++) {
                    int nextX = x + directors[i][0];
                    int nextY = y + directors[i][1];
                    if (nextX < 0 || nextX > rows - 1 || nextY < 0 || nextY > cols - 1) {
                        continue;
                    }
                    // 如果不是空地就绕开，其余情况都加入队列
                    if (grid[nextX][nextY] != 0) {
                        continue;
                    }
                    if (countCalc[nextX][nextY] != tallCount) {
                        continue;
                    }
                    int currentDis = tempDistance + 1;
                    queue.add(new int[]{nextX, nextY, currentDis});
                    countCalc[nextX][nextY] = tallCount + 1;
                    distance[nextX][nextY] = distance[nextX][nextY] + currentDis;
                    if (distance[nextX][nextY] < ans) {
                        ans = Math.min(ans, distance[nextX][nextY]);
                    }
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}