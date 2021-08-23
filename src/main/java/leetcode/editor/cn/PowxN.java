//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x⁴
//
// Related Topics 递归 数学 👍 718 👎 0

package leetcode.editor.cn;

//50:Pow(x, n)
class PowxN {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PowxN().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            double ans = 1;
            if (n < 0) {
                x = 1 / x;
            }
            long exp = n;
            exp = Math.abs(exp);
            while (exp > 0) {
                if (exp % 2 == 1) {
                    ans = ans * x;
                }
                x *= x;
                exp /= 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}