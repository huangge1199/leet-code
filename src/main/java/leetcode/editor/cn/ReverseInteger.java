//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2759 👎 0

package leetcode.editor.cn;

//7:整数反转
public class ReverseInteger {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(1534236469));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
//            boolean is = x < 0;
//            if (is) {
//                x = -x;
//            }
//            StringBuilder sb = new StringBuilder(""+x);
//            sb.reverse();
//            try {
//                x = is ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
//            }catch (Exception e){
//                x = 0;
//            }
//            return x;
            int rev = 0;
            while (x != 0) {
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}