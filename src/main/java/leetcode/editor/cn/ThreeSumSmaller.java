//给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的
//三元组 i, j, k 个数（0 <= i < j < k < n）。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [-2,0,1,3], target = 2
//输出: 2 
//解释: 因为一共有两个三元组满足累加和小于 2:
//     [-2,0,1]
//     [-2,0,3]
// 
//
// 示例 2： 
//
// 
//输入: nums = [], target = 0
//输出: 0 
//
// 示例 3： 
//
// 
//输入: nums = [0], target = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// n == nums.length 
// 0 <= n <= 3500 
// -100 <= nums[i] <= 100 
// -100 <= target <= 100 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 106 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//259:较小的三数之和
public class ThreeSumSmaller {
    public static void main(String[] args) {
        Solution solution = new ThreeSumSmaller().new Solution();
        // TO TEST
        solution.threeSumSmaller(new int[]{-1, 1, -1, -1}, -1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int sum;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        count += (right - left);
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
