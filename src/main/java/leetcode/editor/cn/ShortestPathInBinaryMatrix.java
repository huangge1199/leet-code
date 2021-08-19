//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 116 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1091:二进制矩阵中的最短路径
class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
//        TwoArray twoArray = new TwoArray("[[0,1],[1,0]]", true);
//        TwoArray twoArray = new TwoArray("[[0,0,0],[1,1,0],[1,1,0]]",true);
        TwoArray twoArray = new TwoArray("[[1,0,0],[1,1,0],[1,1,0]]", true);
        System.out.println(solution.shortestPathBinaryMatrix(twoArray.getArr()));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[grid.length - 1][grid[0].length - 1] == 1 || grid[0][0] == 1) {
                return -1;
            }
            if (grid.length == 1) {
                return 1;
            }
            boolean[][] use = new boolean[grid.length][grid[0].length];
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            list.add(new Pair<>(-1, -1));
            list.add(new Pair<>(-1, 0));
            list.add(new Pair<>(-1, 1));
            list.add(new Pair<>(0, -1));
            list.add(new Pair<>(0, 1));
            list.add(new Pair<>(1, -1));
            list.add(new Pair<>(1, 0));
            list.add(new Pair<>(1, 1));
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(0, 0));
            use[0][0] = true;
            int count = 1;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Pair<Integer, Integer> pair = queue.poll();
                    for (Pair<Integer, Integer> p : list) {
                        int x = pair.getKey() + p.getKey();
                        int y = pair.getValue() + p.getValue();
                        if (x == grid.length - 1 && y == grid[0].length - 1) {
                            return count;
                        }
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || use[x][y]) {
                            continue;
                        }
                        if (grid[x][y] == 0) {
                            queue.add(new Pair<>(x, y));
                        }
                        use[x][y] = true;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}