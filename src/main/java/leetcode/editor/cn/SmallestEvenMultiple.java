//给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：10
//解释：5 和 2 的最小公倍数是 10 。
// 
//
// 示例 2： 
//
// 输入：n = 6
//输出：6
//解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 150 
// 
//
// 👍 5 👎 0

package leetcode.editor.cn;

//2413:最小偶倍数
public class SmallestEvenMultiple {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new SmallestEvenMultiple().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestEvenMultiple(int n) {
            return n % 2 == 0 ? n : n * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}