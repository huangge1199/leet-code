//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 233 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//1631:最小体力消耗路径
class PathWithMinimumEffort {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PathWithMinimumEffort().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int[][] use = new int[heights.length][heights[0].length];
            for (int[] ints : use) {
                Arrays.fill(ints, -1);
            }
            use[0][0] = 0;
            int[] xIndex = new int[]{1, -1, 0, 0};
            int[] yIndex = new int[]{0, 0, 1, -1};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = arr[0] + xIndex[i];
                    int y = arr[1] + yIndex[i];
                    if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) {
                        continue;
                    }
                    int heigh = Math.max(Math.abs(heights[x][y] - heights[arr[0]][arr[1]]),use[arr[0]][arr[1]]);
                    if (use[x][y] == -1) {
                        use[x][y] = heigh;
                        queue.add(new int[]{x, y});
                    } else if (use[x][y] > heigh) {
                        use[x][y] = heigh;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            return use[heights.length - 1][heights[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}