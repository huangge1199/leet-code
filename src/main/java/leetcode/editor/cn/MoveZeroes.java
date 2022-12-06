//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1110 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//283:移动零
class MoveZeroes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MoveZeroes().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int low = 0, fast = 1;
            for (; fast < nums.length; fast++) {
                if (nums[low] == 0) {
                    if (nums[fast] == 0) continue;
                    else {
                        int tmp = nums[low];
                        nums[low] = nums[fast];
                        nums[fast] = tmp;
                        low++;
                    }
                    continue;
                }
                low++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}