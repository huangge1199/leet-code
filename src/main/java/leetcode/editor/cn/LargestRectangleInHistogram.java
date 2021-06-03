//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1383 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//84:柱状图中最大的矩形
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int length = heights.length;
            int[] left = new int[length];
            int[] right = new int[length];

            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < length; ++i) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(i);
            }

            stack.clear();
            for (int i = length - 1; i >= 0; --i) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = (stack.isEmpty() ? length : stack.peek());
                stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < length; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}