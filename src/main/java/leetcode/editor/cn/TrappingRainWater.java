//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2384 👎 0

package leetcode.editor.cn;

//42:接雨水
public class TrappingRainWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int size = height.length;
            if (size < 2) {
                return 0;
            }
            int[] left = new int[size];
            left[0] = height[0];
            for (int i = 1; i < size; i++) {
                left[i] = Math.max(left[i - 1], height[i]);
            }
            int[] right = new int[size];
            right[size - 1] = height[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], height[i]);
            }
            int count = 0;
            for (int i = 0; i < size; i++) {
                count += Math.min(left[i], right[i]) - height[i];
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}