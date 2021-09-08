//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心 位运算 数组 矩阵 👍 206 👎 0

package leetcode.editor.cn;

//861:翻转矩阵后的得分
class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ScoreAfterFlippingMatrix().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ret = m * (1 << (n - 1));
            for (int j = 1; j < n; j++) {
                int nOnes = 0;
                for (int[] ints : grid) {
                    if (ints[0] == 1) {
                        nOnes += ints[j];
                    } else {
                        nOnes += (1 - ints[j]);
                    }
                }
                int k = Math.max(nOnes, m - nOnes);
                ret += k * (1 << (n - j - 1));
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}