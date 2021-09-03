//给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。 
//
// 请仔细阅读下面的示例。 
//
// 
//
// 示例： 
//
// 输入：
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//输出：
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
// 
// Related Topics 数组 哈希表 矩阵 👍 55 👎 0

package leetcode.editor.cn;

//311:稀疏矩阵的乘法
class SparseMatrixMultiplication {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SparseMatrixMultiplication().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] multiply(int[][] mat1, int[][] mat2) {
            int[][] result = new int[mat1.length][mat2[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < mat1[0].length; k++) {
                        result[i][j] += mat1[i][k] * mat2[k][j];
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}