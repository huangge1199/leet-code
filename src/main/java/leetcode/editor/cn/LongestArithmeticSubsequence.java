//给定一个整数数组 A，返回 A 中最长等差子序列的长度。 
//
// 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A
//.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。 
//
// 
//
// 示例 1： 
//
// 输入：[3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 输入：[9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 输入：[20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 2000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 144 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//1027:最长等差数列
class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestArithmeticSubsequence().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int[][] dp = new int[nums.length][max*2+1];
            for (int[] t:dp){
                Arrays.fill(t,-1);
            }

            int result = 2;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    int index = nums[i]-nums[j]+max;
                    dp[i][index]=Math.max(2,dp[j][index]+1);
                    result = Math.max(result,dp[i][index]);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}