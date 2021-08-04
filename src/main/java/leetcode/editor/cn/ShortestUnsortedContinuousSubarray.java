//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 596 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author huangge1199
 */
//581:最短无序连续子数组
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] sort = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sort);
            boolean bl = false;
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] != sort[start]) {
                    break;
                }
                start++;
            }
            while (start < end) {
                if (nums[end] != sort[end]) {
                    break;
                }
                end--;
            }
            return start == end ? 0 : end - start + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}