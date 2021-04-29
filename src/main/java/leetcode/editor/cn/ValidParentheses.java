//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2289 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//20:有效的括号
public class ValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("()");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<>();
            int length = s.length();
            if (length % 2 == 1) {
                return false;
            }
            Map<String, String> map = new HashMap<String, String>() {
                {
                    put(")", "(");
                    put("}", "{");
                    put("]", "[");
                }
            };
            for (int i = 0; i < length; i++) {
                String ch = s.substring(i, i + 1);
                if (!map.containsKey(ch) || stack.isEmpty() || !map.get(ch).equals(stack.pop())) {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}