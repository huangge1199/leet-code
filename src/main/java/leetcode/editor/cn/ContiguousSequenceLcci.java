//给定一个整数数组，找出总和最大的连续数列，并返回总和。 
//
// 示例： 
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
//输出： 6
//解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶： 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治 动态规划 👍 109 👎 0

package leetcode.editor.cn;

//面试题 16.17:连续数列
public class ContiguousSequenceLcci {
    public static void main(String[] args) {
        Solution solution = new ContiguousSequenceLcci().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int b = nums[0];
            int sum = b;
            for (int i = 1; i < nums.length; i++) {
                if (b < 0) {
                    b = nums[i];
                } else {
                    b += nums[i];
                }
                if (b > sum) {
                    sum = b;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}