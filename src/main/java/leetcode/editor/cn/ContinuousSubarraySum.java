//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数学 动态规划 
// 👍 247 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//523:连续的子数组和
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ContinuousSubarraySum().new Solution();
        System.out.println(solution.checkSubarraySum(new int[]{23, 6, 9}, 6));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
//            int length = nums.length;
//            long[] sum = new long[length + 1];
//            sum[0] = 0;
//            for (int i = 0; i < length; i++) {
//                sum[i + 1] = sum[i] + nums[i];
//            }
//            for (int i = 0; i < length + 1; i++) {
//                for (int j = i + 2; j < length + 1; j++) {
//                    if ((sum[j] - sum[i]) % k == 0) {
//                        return true;
//                    }
//                }
//            }
//            return false;int length = nums.length;
            int length = nums.length;
            if (length < 2) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum = (sum + nums[i]) % k;
                if (map.containsKey(sum)) {
                    if (i - map.get(sum) >= 2) {
                        return true;
                    }
                } else {
                    map.put(sum, i);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}