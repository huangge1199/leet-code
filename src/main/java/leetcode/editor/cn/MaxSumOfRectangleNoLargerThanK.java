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

import java.util.TreeSet;

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
            int ans = Integer.MIN_VALUE;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; ++i) { // 枚举上边界
                int[] sum = new int[n];
                for (int j = i; j < m; ++j) { // 枚举下边界
                    for (int c = 0; c < n; ++c) {
                        sum[c] += matrix[j][c]; // 更新每列的元素和
                    }
                    TreeSet<Integer> sumSet = new TreeSet<Integer>();
                    sumSet.add(0);
                    int s = 0;
                    for (int v : sum) {
                        s += v;
                        Integer ceil = sumSet.ceiling(s - k);
                        if (ceil != null) {
                            ans = Math.max(ans, s - ceil);
                        }
                        sumSet.add(s);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}