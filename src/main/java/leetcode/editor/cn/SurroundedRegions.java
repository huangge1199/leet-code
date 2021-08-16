//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 587 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//130:被围绕的区域
class SurroundedRegions {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SurroundedRegions().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            boolean[][] use = new boolean[board.length][board[0].length];
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O') {
                    queue.add(new Pair<>(i, 0));
                    use[i][0] = true;
                }
                if (board[i][board[0].length - 1] == 'O') {
                    queue.add(new Pair<>(i, board[0].length - 1));
                    use[i][board[0].length - 1] = true;
                }
            }
            for (int i = 1; i < board[0].length - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.add(new Pair<>(0, i));
                    use[0][i] = true;
                }
                if (board[board.length - 1][i] == 'O') {
                    queue.add(new Pair<>(board.length - 1, i));
                    use[board.length - 1][i] = true;
                }
            }
            int[] xIndex = new int[]{-1, 1, 0, 0};
            int[] yIndex = new int[]{0, 0, -1, 1};
            while (!queue.isEmpty()) {
                Pair<Integer, Integer> pair = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = pair.getKey() + xIndex[i];
                    int y = pair.getValue() + yIndex[i];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || use[x][y] || board[x][y] == 'X') {
                        continue;
                    }
                    queue.add(new Pair<>(x, y));
                    use[x][y] = true;
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O' && !use[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}