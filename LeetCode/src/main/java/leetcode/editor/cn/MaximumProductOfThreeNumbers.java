//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 
// 👍 295 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//628:三个数的最大乘积
public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[nums.length - 1] * nums[0] * nums[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}