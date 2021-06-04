//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 400 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//227:基本计算器 II
public class BasicCalculatorIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BasicCalculatorIi().new Solution();
//        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            int num = 0;
            Stack<Integer> stack = new Stack<>();
            char op = '+';
            s=s.replace(" ","");
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                }
                if (!Character.isDigit(ch) || i == s.length() - 1) {
                    switch (op) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                            break;
                    }
                    op = ch;
                    num = 0;
                }
            }
            int result = 0;
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}