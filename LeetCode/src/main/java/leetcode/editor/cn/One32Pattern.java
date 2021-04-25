//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 503 👎 0

package leetcode.editor.cn;

import java.util.Stack;
import java.util.TreeMap;

//456:132 模式
public class One32Pattern {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new One32Pattern().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }

            int left = nums[0];
            TreeMap<Integer, Integer> right = new TreeMap<>();

            for (int k = 2; k < n; k++) {
                right.put(nums[k], right.getOrDefault(nums[k], 0) + 1);
            }

            for (int j = 1; j < n - 1; j++) {
                if (left < nums[j]) {
                    Integer next = right.ceilingKey(left + 1);
                    if (next != null && next < nums[j]) {
                        return true;
                    }
                }
                left = Math.min(left, nums[j]);
                right.put(nums[j + 1], right.get(nums[j + 1]) - 1);
                if (right.get(nums[j + 1]) == 0) {
                    right.remove(nums[j + 1]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}