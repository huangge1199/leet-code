//你需要找到由两个 n 位数的乘积组成的最大回文数。 
//
// 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。 
//
// 示例: 
//
// 输入: 2 
//
// 输出: 987 
//
// 解释: 99 x 91 = 9009, 9009 % 1337 = 987 
//
// 说明: 
//
// n 的取值范围为 [1,8]。 
// Related Topics 数学 👍 41 👎 0

package leetcode.editor.cn;

//479:最大回文数乘积
class LargestPalindromeProduct {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LargestPalindromeProduct().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPalindrome(int n) {
            if (n == 1) {
                return 9;
            }
            long max = (long) Math.pow(10, n) - 1;
            for (long i = max; i > max / 10; i--) {
                long mul = Long.parseLong(i + new StringBuilder("" + i).reverse().toString());
                for (long j = max; j * j >= mul; j--) {
                    if (mul % j == 0) {
                        return (int) (mul % 1337);
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}