//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 105 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
// Related Topics 数组 二分查找 
// 👍 256 👎 0

package leetcode.editor.cn;

//540:有序数组中的单一元素
class SingleElementInASortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SingleElementInASortedArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int singleNonDuplicate(int[] nums) {
//            for (int i = 0; i < nums.length; i = i + 2) {
//                if (i + 1 == nums.length || nums[i] != nums[i + 1]) {
//                    return nums[i];
//                }
//            }
//            return 0;
//        }
        public int singleNonDuplicate(int[] nums) {
            int result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result ^= nums[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}