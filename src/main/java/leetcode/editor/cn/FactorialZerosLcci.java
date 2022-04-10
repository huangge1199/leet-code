//设计一个算法，算出 n 阶乘有多少个尾随零。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 👍 66 👎 0

package leetcode.editor.cn;

//面试题 16.05:阶乘尾数
public class FactorialZerosLcci {
    public static void main(String[] args) {
        Solution solution = new FactorialZerosLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            int count = 0;
            while (n >= 5) {
                count += n / 5;
                n /= 5;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
