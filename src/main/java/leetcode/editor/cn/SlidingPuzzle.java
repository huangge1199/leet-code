////在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（
//上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 示例 2: 
//
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 示例 3: 
//
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//
// 提示： 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// board[i][j] 中每个值都 不同 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 299 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 773:滑动谜题
public class SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int slidingPuzzle(int[][] board) {
            int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(board[i][j]);
                }
            }
            if (sb.toString().equals("123450")) {
                return 0;
            }
            int step = 0;
            List<String> use = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(sb.toString());
            use.add(sb.toString());
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                for (int i = 0; i < size; i++) {
                    String str = queue.poll();
                    char[] chs = str.toCharArray();
                    int index = str.indexOf("0");
                    for (int swap : neighbors[index]) {
                        chs[index] = chs[swap];
                        chs[swap] = '0';
                        String tmp = new String(chs);
                        if (tmp.equals("123450")) {
                            return step;
                        }
                        if (!use.contains(tmp)) {
                            queue.add(tmp);
                            use.add(tmp);
                        }
                        chs[swap] = chs[index];
                        chs[index] = 0;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}