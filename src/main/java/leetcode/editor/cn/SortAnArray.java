//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 315 👎 0

package leetcode.editor.cn;

import java.util.Random;

//912:排序数组
class SortAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SortAnArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Random random;

        public int[] sortArray(int[] nums) {
            random = new Random(System.currentTimeMillis());
            pivot(nums, 0, nums.length - 1);
            return nums;
        }

        private void pivot(int[] nums, int start, int end) {
            if (start >= end)
                return;
            int mid = random.nextInt(end - start + 1) + start;
            swap(nums, start, mid);
            int num = nums[start];
            int left = start + 1;
            int right = end;
            while (left < right) {
                while (left < right && nums[left] <= num)
                    left++;
                while (left < right && nums[right] >= num)
                    right--;
                swap(nums, left, right);
            }
            if (nums[left] <= num)
                swap(nums, left, start);
            else {
                swap(nums, left - 1, start);
                left--;
            }
            pivot(nums, left + 1, end);
            pivot(nums, start, left - 1);
        }

        private void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}