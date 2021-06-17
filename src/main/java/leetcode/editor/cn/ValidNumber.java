//有效数字（按顺序）可以分成以下几个部分： 
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下： 
//
// 
// ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
// "53.5e93", "-123.456e789"] 
// 
//
// 部分无效数字列举如下： 
//
// 
// ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
// 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = ".1"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
// Related Topics 数学 字符串 
// 👍 217 👎 0

package leetcode.editor.cn;

import java.util.regex.Pattern;

//65:有效数字
public class ValidNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidNumber().new Solution();
        System.out.println(solution.isNumber("2"));
        System.out.println(solution.isNumber("0089"));
        System.out.println(solution.isNumber("-0.1"));
        System.out.println(solution.isNumber("+3.14"));
        System.out.println(solution.isNumber("4."));
        System.out.println(solution.isNumber("-.9"));
        System.out.println(solution.isNumber("2e10"));
        System.out.println(solution.isNumber("-90E3"));
        System.out.println(solution.isNumber("3e+7"));
        System.out.println(solution.isNumber("+6e-1"));
        System.out.println(solution.isNumber("53.5e93"));
        System.out.println(solution.isNumber("-123.456e789"));
        System.out.println("----------------------------------");
        System.out.println(solution.isNumber("abc"));
        System.out.println(solution.isNumber("1a"));
        System.out.println(solution.isNumber("1e"));
        System.out.println(solution.isNumber("e3"));
        System.out.println(solution.isNumber("99e2.5"));
        System.out.println(solution.isNumber("--6"));
        System.out.println(solution.isNumber("-+3"));
        System.out.println(solution.isNumber("95a54e53"));
        System.out.println(solution.isNumber("6+1"));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        String pattern = "^[+-]?((\\d*\\.?\\d+)|(\\d+\\.?\\d*))([eE][+-]?\\d+)?$";
        return Pattern.matches(pattern,s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}