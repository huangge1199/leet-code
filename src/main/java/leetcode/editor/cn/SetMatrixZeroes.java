//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 512 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//73:矩阵置零
class SetMatrixZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SetMatrixZeroes().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int xLength = matrix.length;
            int yLength = matrix[0].length;

            boolean y = false, x = false;
            for (int[] ints : matrix) {
                if (ints[0] == 0) {
                    y = true;
                    break;
                }
            }
            for (int j = 0; j < yLength; j++) {
                if (matrix[0][j] == 0) {
                    x = true;
                    break;
                }
            }

            for (int i = 1; i < xLength; i++) {
                for (int j = 1; j < yLength; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            for (int j = 1; j < yLength; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < xLength; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < xLength; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }

            if (y) for (int i = 0; i < xLength; i++) matrix[i][0] = 0;
            if (x) Arrays.fill(matrix[0], 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}