//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1706 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

//32:最长有效括号
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses("(()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Pair<String, Integer>> stack = new Stack<>();
            while (s.startsWith(")")) {
                s = s.substring(1);
            }
            while (s.endsWith("(")) {
                s = s.substring(0, s.length() - 1);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.add(new Pair<>("(", i));
                } else if (!stack.isEmpty() && "(".equals(stack.peek().getKey())) {
                    list.add(stack.pop().getValue());
                    list.add(i);
                } else {
                    stack.add(new Pair<>(")", i));
                }
            }
            if (list.size() == 0) {
                return 0;
            }
            Collections.sort(list);
            int max = 0;
            int count = 1;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == list.get(i - 1) + 1) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            return Math.max(max, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}