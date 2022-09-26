//一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。 
//
// 
// 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。 
// 
//
// 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对 109 + 7 取余 的
//结果。 
//
// 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。 
//
// 子数组 定义为一个数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,2]
//输出：14
//解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
//2 * (2+3+2) = 2 * 7 = 14 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,3,1,2]
//输出：18
//解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
//3 * (3+3) = 3 * 6 = 18 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,1,5,6,4,2]
//输出：60
//解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
//4 * (5+6+4) = 4 * 15 = 60 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 107 
// 
// Related Topics 排序 并查集 队列 二分查找 动态规划 
// 👍 22 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

//1856:子数组最小乘积的最大值
public class MaximumSubarrayMinProduct {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumSubarrayMinProduct().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumMinProduct(int[] nums) {
            int length = nums.length;
            long[] sum = new long[length];
            sum[0] = nums[0];
            for (int i = 1; i < length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }

            int[] start = new int[length];
            Arrays.fill(start, -1);
            int[] end = new int[length];
            Arrays.fill(end, length);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    end[stack.peek()] = i;
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    start[i] = stack.peek();
                }
                stack.push(i);
            }

            long max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i] * (sum[end[i] - 1] - (start[i] == -1 ? 0 : sum[start[i]])), max);
            }
            return (int) (max % ((int) Math.pow(10, 9) + 7));
//            long mod = 1000000000+7;
//            return (int) (max % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}