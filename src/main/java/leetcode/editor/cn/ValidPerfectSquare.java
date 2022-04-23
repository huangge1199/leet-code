//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 371 👎 0

package leetcode.editor.cn;

//367:有效的完全平方数
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        // TO TEST
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(808201));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num * num == num) {
                return true;
            }
            int left = 0;
            int right = num;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                long mul = (long) mid * mid;
                if (mul == num) {
                    return true;
                }
                if (mul < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
