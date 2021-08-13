//给定一个正整数数组 nums和整数 k 。 
//
// 请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
// Related Topics 数组 滑动窗口 
// 👍 272 👎 0

package leetcode.editor.cn;

//713:乘积小于K的子数组
class SubarrayProductLessThanK {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SubarrayProductLessThanK().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k == 0) {
                return 0;
            }
            double logk = Math.log(k);
            double[] logs = new double[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                logs[i + 1] = logs[i] + Math.log(nums[i]);
            }

            int result = 0;
            for (int i = 0; i < logs.length; i++) {
                int start = i + 1;
                int end = logs.length;
                while (start < end) {
                    int mid = (end + start) / 2;
                    if (logs[mid] < logs[i] + logk - 1e-9) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                result += start - i - 1;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}