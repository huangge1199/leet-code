//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1054 👎 0

package leetcode.editor.cn;

//41:缺失的第一个正数
public class FirstMissingPositive {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{1,2,0});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            boolean is = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    is = false;
                }
                if (nums[i] <= 0) {
                    nums[i] = 1;
                }
            }
            if (is) {
                return 1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i]) <= nums.length && nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    return i + 1;
                }
            }
            return nums.length + 1;
            //未完成的
//            int index;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == i) {
//                    continue;
//                }
//                index = i;
//                while (nums[index] != index && index >= 0 && index < nums.length) {
//                    int temp = nums[nums[index]];
//                    nums[nums[index]] = nums[index];
//                    index = temp;
//                }
//                if (nums[index] == nums.length) {
//                    nums[0] = nums[index];
//                }
//            }
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] != i) {
//                    return i;
//                }
//            }
//            return nums[0] == nums.length ? nums.length + 1 : nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}