//给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ： 
//
// 
// 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。 
// 
//
// 如果两个元素有 公共边 ，那么它们就是 相邻 的。 
//
// 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,-1],[-1,1]]
//输出：4
//解释：我们可以执行以下操作使和等于 4 ：
//- 将第一行的 2 个元素乘以 -1 。
//- 将第一列的 2 个元素乘以 -1 。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
//输出：16
//解释：我们可以执行以下操作使和等于 16 ：
//- 将第二行的最后 2 个元素乘以 -1 。
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 2 <= n <= 250 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 
// 👍 0 👎 0

package leetcode.editor.cn;

//1975:最大方阵和
class MaximumMatrixSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumMatrixSum().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int min = Integer.MAX_VALUE;
            long sum = 0;
            long mul = 1;
            int count = 0;
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    sum += Math.abs(ints[j]);
                    if (ints[j] != 0) {
                        mul = mul * ints[j] > 0 ? 1 : -1;
                        min = Math.min(min, Math.abs(ints[j]));
                    } else {
                        count++;
                    }
                }
            }
            return mul < 0 && count == 0 ? sum - 2L * min : sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}