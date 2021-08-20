//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1315 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//55:跳跃游戏
class JumpGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new JumpGame().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            boolean[] use = new boolean[nums.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            use[0] = true;
            while (!queue.isEmpty()) {
                int index = queue.poll();
                if (index + nums[index] >= nums.length - 1) {
                    return true;
                }
                for (int i = index + 1; i <= index + nums[index]; i++) {
                    if (!use[i]) {
                        queue.add(i);
                        use[i] = true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}