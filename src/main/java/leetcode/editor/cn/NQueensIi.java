//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 回溯 👍 340 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//52:N皇后 II
public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            return backtrack(n, 0, columns, diagonals1, diagonals2);
        }

        public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
                return count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}