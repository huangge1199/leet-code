//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 👍 572 👎 0

package leetcode.editor.cn;

//343:整数拆分
class IntegerBreak {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new IntegerBreak().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            int ans = 1;
            int x = n / 3;
            int y = n % 3;
            if (y == 0) {
                ans *= (int) Math.pow(3, x);
            } else if (y == 1) {
                ans *= (int) Math.pow(3, x - 1) * 4;
            } else {
                ans *= (int) Math.pow(3, x) * 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}