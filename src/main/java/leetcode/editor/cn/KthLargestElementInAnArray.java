//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1170 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Queue;

//215:数组中的第K个最大元素
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}