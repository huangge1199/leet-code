//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 179 👎 0

package leetcode.editor.cn;

//剑指 Offer 53 - I:在排序数组中查找数字 I
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int start = binarySearch(nums, target, true);
            int end = binarySearch(nums, target, false) - 1;
            if (start <= end && end < nums.length && nums[start] == target && nums[end] == target) {
                return end - start + 1;
            }
            return 0;
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int start = 0, end = nums.length - 1, ans = nums.length;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    end = mid - 1;
                    ans = mid;
                } else {
                    start = mid + 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}