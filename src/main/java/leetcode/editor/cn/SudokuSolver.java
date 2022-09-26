//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 哈希表 回溯算法 
// 👍 819 👎 0

package leetcode.editor.cn;

import java.util.*;

//37:解数独
public class SudokuSolver {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SudokuSolver().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            List<Integer>[][] boards = new ArrayList[9][9];
            List<Integer>[] rows = new ArrayList[9];
            List<Integer>[] columns = new ArrayList[9];
            List<Integer>[] others = new ArrayList[9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    boards[i][j] = new ArrayList<>();
                }
                rows[i] = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
                columns[i] = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
                others[i] = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            }
            List<List<Integer>> left = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char ch = board[i][j];
                    if (ch == '.') {
                        left.add(Arrays.asList(i, j));
                        continue;
                    }
                    rows[i].remove(ch - '0');
                    columns[j].remove(ch - '0');
                    int otherIndex = (i / 3) * 3 + j / 3;
                    others[otherIndex].remove(ch - '0');
                }
            }
            while (left.size() > 0) {
                for (int i = 0; i < left.size(); i++) {
                    List<Integer> list = left.get(i);
                    int r = 0, c = 0, o = 0;
                    int x = list.get(0), y = list.get(1);
                    List<Integer> tempR = rows[x];
                    List<Integer> tempC = columns[y];
                    int otherIndex = (x / 3) * 3 + y / 3;
                    List<Integer> tempO = others[otherIndex];
                    while (r < tempR.size() && c < tempC.size() && o < tempO.size()) {
                        if (tempR.get(r).equals(tempC.get(c)) && tempC.get(c).equals(tempO.get(o))) {
                            boards[x][y].add(tempC.get(c));
                        }
                        while (tempR.get(r) < tempC.get(c)) {
                            tempR.remove(r);
                        }
                        while (tempC.get(c) < tempR.get(r)) {
                            tempC.remove(c);
                        }
                        while (tempO.get(o) < tempC.get(c)) {
                            tempO.remove(o);
                        }
                        while (tempC.get(c) < tempO.get(o)) {
                            tempC.remove(c);
                        }
                        while (tempO.get(o) < tempR.get(r)) {
                            tempO.remove(o);
                        }
                        while (tempR.get(r) < tempO.get(o)) {
                            tempR.remove(r);
                        }
                    }
                    if (boards[x][y].size() == 1) {
                        board[x][y] = Character.forDigit(boards[x][y].get(0), 10);
                        rows[x].remove(board[x][y] - '0');
                        columns[y].remove(board[x][y] - '0');
                        others[otherIndex].remove(board[x][y] - '0');
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}