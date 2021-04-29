//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
//
// 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同 
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
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 95 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//1081:不同字符的最小子序列
public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            boolean[] isHave = new boolean[26];
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!isHave[ch - 'a']) {
                    while (!stack.isEmpty() && stack.peek() > ch) {
                        if (count[stack.peek() - 'a'] <= 0) {
                            break;
                        }
                        isHave[stack.peek() - 'a'] = false;
                        stack.pop();
                    }
                    isHave[ch - 'a'] = true;
                    stack.push(ch);
                }
                count[ch - 'a']--;
            }
            StringBuilder str = new StringBuilder();
            while (!stack.isEmpty()) {
                str.insert(0, stack.pop());
            }
            return str.toString();
            //官网
//            boolean[] vis = new boolean[26];
//            int[] num = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                num[s.charAt(i) - 'a']++;
//            }
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                char ch = s.charAt(i);
//                if (!vis[ch - 'a']) {
//                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
//                        if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
//                            vis[sb.charAt(sb.length() - 1) - 'a'] = false;
//                            sb.deleteCharAt(sb.length() - 1);
//                        } else {
//                            break;
//                        }
//                    }
//                    vis[ch - 'a'] = true;
//                    sb.append(ch);
//                }
//                num[ch - 'a']--;
//            }
//            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}