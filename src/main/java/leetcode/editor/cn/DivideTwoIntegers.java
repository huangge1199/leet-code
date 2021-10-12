//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 👍 700 👎 0

package leetcode.editor.cn;

//29:两数相除
class DivideTwoIntegers {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new DivideTwoIntegers().new Solution();
        solution.divide(-2147483648, 2);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || dividend == 0) {
                return 0;
            }
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                return dividend == -2147483648 ? 2147483647 : -dividend;
            }
            if (divisor == -2147483648) {
                return dividend == -2147483648 ? 1 : 0;
            }
            int count = 0;
            int bl1 = 0;
            int bl2 = 0;
            int temp = dividend;
            if (dividend == -2147483648) {
                dividend = 2147483647;
                bl1 = 1;
            } else if (dividend < 0) {
                dividend = -dividend;
                bl1 = 1;
            }
            if (divisor < 0) {
                divisor = -divisor;
                bl2 = 1;
            }
            while (dividend >= divisor) {
                count++;
                dividend -= divisor;
            }
            if (temp == -2147483648) {
                if (dividend + 1 >= divisor) {
                    count++;
                }
            }
            return (bl1 ^ bl2) == 0 ? count : -count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}