//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 718 👎 0

package leetcode.editor.cn;

//494:目标和
public class TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TargetSum().new Solution();
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            sum(nums, target, nums.length - 1);
            return count;
        }

        private void sum(int[] nums, int target, int index) {
            if (index == -1) {
                if (target == 0) {
                    count++;
                }
            } else {
                sum(nums, target + nums[index], index - 1);
                sum(nums, target - nums[index], index - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}