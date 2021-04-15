//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 531 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//213:打家劫舍 II
public class HouseRobberIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(range(Arrays.copyOfRange(nums, 0, length - 1)), range(Arrays.copyOfRange(nums, 1, length)));
        }
        public int range(int[] nums) {
            int length = nums.length;
            int start  = nums[0],end = Math.max(nums[0],nums[1]);
            for (int i = 2; i < length; i++) {
                int temp = end;
                end = Math.max(start+nums[i],end);
                start = temp;
            }
            return end;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}