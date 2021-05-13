//给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。 
//
// 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。 
//
// 在执行完所有删除操作后，返回最终得到的字符串。 
//
// 本题答案保证唯一。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", k = 2
//输出："abcd"
//解释：没有要删除的内容。 
//
// 示例 2： 
//
// 输入：s = "deeedbbcccbdaa", k = 3
//输出："aa"
//解释： 
//先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
//再删除 "bbb"，得到 "dddaa"
//最后删除 "ddd"，得到 "aa" 
//
// 示例 3： 
//
// 输入：s = "pbbcggttciiippooaais", k = 2
//输出："ps"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 2 <= k <= 10^4 
// s 中只含有小写英文字母。 
// 
// Related Topics 栈 
// 👍 88 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//1209:删除字符串中的所有相邻重复项 II
public class RemoveAllAdjacentDuplicatesInStringIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveAllAdjacentDuplicatesInStringIi().new Solution();
        //abcd
        System.out.println(solution.removeDuplicates("abcd", 2));
        //aa
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 3));
        //ps
        System.out.println(solution.removeDuplicates("pbbcggttciiippooaais", 2));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s, int k) {
            int size = 1;
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    size++;
                    if (size == k) {
                        while (size > 1) {
                            stack.pop();
                            size--;
                        }
                        if (!stack.isEmpty()) {
                            Stack<Character> temp = new Stack<>();
                            temp.push(stack.pop());
                            while (!stack.isEmpty() && stack.peek().equals(temp.peek())) {
                                temp.push(stack.pop());
                                size++;
                            }
                            while (!temp.isEmpty()) {
                                stack.push(temp.pop());
                            }
                        }
                    } else {
                        stack.push(ch);
                    }
                } else {
                    stack.push(ch);
                    size = 1;
                }
            }
            StringBuilder sBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                sBuilder.insert(0, stack.pop());
            }
            s = sBuilder.toString();
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}