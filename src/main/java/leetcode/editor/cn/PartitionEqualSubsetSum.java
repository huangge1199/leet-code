//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 888 👎 0

package leetcode.editor.cn;

//416:分割等和子集
class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int length = nums.length;
            if (sum % 2 == 1)
                return false;
            boolean[][] dp = new boolean[length + 1][sum / 2 + 1];
            dp[0][0] = true;
            for (int i = 1; i <= length; i++) {
                for (int j = 0; j <= sum / 2; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                    }
                    dp[i][j] |= dp[i - 1][j];
                }
            }
            return dp[length][sum / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}