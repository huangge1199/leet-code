//给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。 
//
// 示例: 
//
// 输入: nums = [3,5,2,1,6,4]
//输出: 一个可能的解答是 [3,5,1,6,2,4] 
// Related Topics 贪心 数组 排序 👍 71 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//280:摆动排序
class WiggleSort {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new WiggleSort().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] temp = nums.clone();
            Arrays.sort(temp);
            int index = nums.length;
            for (int i = 1; i < nums.length; i += 2) {
                index--;
                nums[i] = temp[index];
            }
            for (int i = 0; i < nums.length; i += 2) {
                index--;
                nums[i] = temp[index];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}