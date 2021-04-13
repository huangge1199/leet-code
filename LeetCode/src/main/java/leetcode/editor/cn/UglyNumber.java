//给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：true
//解释：6 = 2 × 3 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：true
//解释：8 = 2 × 2 × 2
// 
//
// 示例 3： 
//
// 
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
// 
//
// 示例 4： 
//
// 
//输入：n = 1
//输出：true
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics 数学 
// 👍 221 👎 0

package leetcode.editor.cn;

//263:丑数
public class UglyNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new UglyNumber().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            while (n % 5 == 0) {
                n = n / 5;
            }
            while (n % 3 == 0) {
                n = n / 3;
            }
            while (n % 2 == 0) {
                n = n / 2;
            }
            return n == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}