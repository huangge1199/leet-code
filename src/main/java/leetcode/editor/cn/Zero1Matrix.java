//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//输出：
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 446 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//542:01 矩阵
public class Zero1Matrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Zero1Matrix().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            List<Pair<Integer, Integer>> list = Arrays.asList(
                    new Pair<>(-1, 0),
                    new Pair<>(1, 0),
                    new Pair<>(0, -1),
                    new Pair<>(0, 1)
            );
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] is = new boolean[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        is[i][j] = true;
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                for (Pair<Integer, Integer> pair : list) {
                    int x = arr[0] + pair.getKey();
                    int y = arr[1] + pair.getValue();
                    if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || is[x][y] || mat[x][y] != 1) {
                        continue;
                    }
                    mat[x][y] = mat[arr[0]][arr[1]] + 1;
                    is[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            return mat;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}