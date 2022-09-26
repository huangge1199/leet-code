//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
// Related Topics 栈 字符串 
// 👍 204 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//856:括号的分数
public class ScoreOfParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ScoreOfParentheses().new Solution();
        //1
        System.out.println(solution.scoreOfParentheses("()"));
        //2
        System.out.println(solution.scoreOfParentheses("(())"));
        //2
        System.out.println(solution.scoreOfParentheses("()()"));
        //6
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String S) {
            if (S == null) {
                return 0;
            }
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    stack.push(0);
                } else if (S.charAt(i) == ')') {
                    int num = stack.peek() == 0 ? 1 : stack.peek() * 2;
                    stack.pop();
                    if (stack.isEmpty()) {
                        sum += num;
                    } else {
                        stack.push(stack.pop() + num);
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}