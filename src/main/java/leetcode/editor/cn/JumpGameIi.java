//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1053 👎 0

package leetcode.editor.cn;
//45:跳跃游戏 II
public class JumpGameIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int max = 0;
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int next = i+nums[i];
            if(next>=nums.length-1){
                return counts[i]+1;
            }
            if(next>max){
                for (int j = max+1; j <= next; j++) {
                    counts[j] = counts[i]+1;
                }
                max = next;
            }
        }
        return counts[nums.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}