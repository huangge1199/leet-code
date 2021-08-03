//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 973 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//79:单词搜索
public class WordSearch{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new WordSearch().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean exist(char[][] board, String word) {

            String str = Arrays.deepToString(board);
            for (int i = 0; i < word.length(); i++) {
                if (str.indexOf(word.charAt(i)) == -1) {
                    return false;
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, word, i, j, 0, new int[board.length][board[0].length])) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        /**
         * 深度优先搜索
         * @param board 传入的二维字符网格
         * @param word 目标字符串
         * @param i 起点 i 坐标
         * @param j 起点 j 坐标
         * @param index 遍历到word的哪一个位置了
         * @param visit 访问数组，记录哪些地方已经走过
         * @return
         */
        private boolean dfs(char[][] board, String word, int i, int j, int index, int[][] visit) {

            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                    || board[i][j] != word.charAt(index) || visit[i][j] == 1) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            visit[i][j] = 1;
            int[][] direction = new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
            for (int[] d : direction) {
                int[][] copy = new int[visit.length][visit[0].length];
                for (int k = 0; k < visit.length; k++) {
                    copy[k] = Arrays.copyOf(visit[k], visit[0].length);
                }
                if (dfs(board, word, d[0], d[1], index + 1, copy)) {
                    return true;
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}