//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 75 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//1190:反转每对括号间的子串
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        //dcba
        System.out.println(solution.reverseParentheses("(abcd)"));
        //iloveu
        System.out.println(solution.reverseParentheses("(u(love)i)"));
        //leetcode
        System.out.println(solution.reverseParentheses("(ed(et(oc))el)"));
        //apmnolkjihgfedcbq
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses(String s) {
            StringBuilder result = new StringBuilder();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(i, i + 1);
                if (")".equals(str)) {
                    StringBuilder temp = new StringBuilder();
                    while (!"(".equals(stack.peek())) {
                        temp.append(new StringBuilder(stack.pop()).reverse());
                    }
                    if ("(".equals(stack.peek())) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        result.append(temp);
                    } else {
                        stack.push(temp.toString());
                    }
                } else if (stack.isEmpty() && !"(".equals(str)) {
                    result.append(str);
                } else {
                    stack.push(str);
                }
            }
            if (stack.size() == 1) {
                return stack.pop();
            }
            while (!stack.isEmpty()) {
                result.append(new StringBuilder(stack.pop()).reverse());
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}