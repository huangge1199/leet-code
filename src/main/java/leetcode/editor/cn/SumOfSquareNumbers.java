//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 195 👎 0

package leetcode.editor.cn;

//633:平方数之和
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SumOfSquareNumbers().new Solution();
        //true
        System.out.println(solution.judgeSquareSum(5));
        //false
        System.out.println(solution.judgeSquareSum(3));
        //true
        System.out.println(solution.judgeSquareSum(4));
        //true
        System.out.println(solution.judgeSquareSum(2));
        //true
        System.out.println(solution.judgeSquareSum(1));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            int num = (int) Math.sqrt(c);
            int i = num;
            while (i >= Math.sqrt(c - num * num)) {
                if (c == i * i) {
                    return true;
                }
                int num1 = (int) Math.sqrt(c - i * i);
                if (i * i + num1 * num1 == c) {
                    return true;
                }
                i--;
            }
            return false;
//            // 官方
//            for (long a = 0; a * a <= c; a++) {
//                double b = Math.sqrt(c - a * a);
//                if (b == (int) b) {
//                    return true;
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}