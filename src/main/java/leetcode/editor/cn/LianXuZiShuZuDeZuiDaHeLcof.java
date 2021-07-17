//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 339 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//剑指 Offer 42:连续子数组的最大和
class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2, -1}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int cur = 0;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                cur = Math.max(cur + num, num);
                max = Math.max(max, cur);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}