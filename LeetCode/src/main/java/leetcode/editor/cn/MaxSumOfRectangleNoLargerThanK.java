//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -105 <= k <= 105 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 队列 二分查找 动态规划 
// 👍 225 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//363:矩形区域不超过 K 的最大数值和
public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaxSumOfRectangleNoLargerThanK().new Solution();
//        //2
//        System.out.println(solution.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
//        //3
//        System.out.println(solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
//        //-1
//        System.out.println(solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
        //8
        System.out.println(solution.maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 8));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int xLength = matrix.length;
            int yLength = matrix[0].length;
            int[][] sums = new int[xLength][yLength];
            for (int i = 0; i < xLength; i++) {
                int sum = 0;
                for (int j = 0; j < yLength; j++) {
                    sum += matrix[i][j];
                    sums[i][j] = sum;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = yLength - 1; i >= 0; i--) {
                for (int l = 0; l <= i; l++) {
                    int sum = 0;
                    for (int j = 0; j < xLength; j++) {
                        sum += l == 0 ? sums[j][i] : sums[j][i] - sums[j][i-l];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}