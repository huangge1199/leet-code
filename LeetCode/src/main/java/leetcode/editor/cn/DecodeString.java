//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 741 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//394:字符串解码
public class DecodeString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new DecodeString().new Solution();
        //accaccacc
        System.out.println(solution.decodeString("3[a2[c]]"));
        //aaabcbc
        System.out.println(solution.decodeString("3[a]2[bc]"));
//        //accaccacc
//        System.out.println(solution.decodeString("3[a2[c]]"));
//        //abcabccdcdcdef
//        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
//        //abccdcdcdxyz
//        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            StringBuilder str = new StringBuilder();
            while (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
                str.append(s.charAt(0));
                if (s.length() == 1) {
                    return str.toString();
                }
                s = s.substring(1);
            }
            int num = Integer.parseInt(s.substring(0, s.indexOf("[")));
            for (int i = 0; i < num; i++) {
                str.append(decodeString(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]"))));
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}