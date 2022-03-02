//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 10¹⁸ - 1] 范围内的整数 
// 
// Related Topics 数学 字符串 👍 125 👎 0

package leetcode.editor.cn;

//564:寻找最近的回文数
//测试用例1213，本地结果是对的，力扣上结果不对
public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        Solution solution = new FindTheClosestPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.nearestPalindromic("1213"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String nearestPalindromic(String n) {
            if (n.length() == 1) {
                return String.valueOf(Integer.parseInt(n) - 1);
            }
            StringBuilder num = new StringBuilder();
            num.append(n, 0, n.length() / 2);
            if (n.length() % 2 == 0) {
                num = new StringBuilder("" + num + num.reverse());
            } else {
                num.append(num.reverse()).insert(n.length() / 2, n.charAt(n.length() / 2));
            }
            long ori = Long.parseLong(n);
            long equ = Long.parseLong(num.toString());
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < n.length(); i++) {
                temp.append("9");
            }
            long small = Long.parseLong(temp.toString());
            return ori - small <= Math.abs(ori - equ) ? temp.toString() : num.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
