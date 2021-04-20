//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 518 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//316:去除重复字母
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));//abc
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - 'a']) {
                    while (!stack.empty() && stack.peek() > ch) {
                        if (num[stack.peek() - 'a'] > 0) {
                            vis[stack.peek() - 'a'] = false;
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;
                    stack.push(ch);
                }
                num[ch - 'a'] -= 1;
            }
            StringBuilder sBuilder = new StringBuilder();
            while (!stack.empty()) {
                sBuilder.insert(0, stack.pop());
            }
            s = sBuilder.toString();
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}