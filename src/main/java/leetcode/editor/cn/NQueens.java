//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 数组 回溯 
// 👍 957 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//51:N 皇后
public class NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NQueens().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append(".");
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(str.toString());
            }
            bfs(list, n, 0);
            return result;
        }

        private void bfs(List<String> list, int n, int row) {
            if (row == list.size()) {
                result.add(new ArrayList<>(list));
                return;
            }

            for (int col = 0; col < n; col++) {
                if (!isValid(list, row, col)) {
                    continue;
                }

                String temp = list.get(row);
                String s1 = temp;
                temp = temp.substring(0,col)+"Q"+temp.substring(col+1);
                bfs(list,n,row+1);

            }
        }

        private boolean isValid(List<String> list, int row, int col) {
            int n = list.size();
            for (String s : list) {
                if (s.charAt(col) == 'Q') {
                    return false;
                }
            }

            int r = row - 1;
            int c = col + 1;
            while (r >= 0 && c < n) {
                if (list.get(r).charAt(c) == 'Q') {
                    return false;
                }
                r--;
                c++;
            }

            r= row - 1;
            c = col - 1;
            while (r>=0&&c>=0){
                if (list.get(r).charAt(c) == 'Q') {
                    return false;
                }
                r--;
                c--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}