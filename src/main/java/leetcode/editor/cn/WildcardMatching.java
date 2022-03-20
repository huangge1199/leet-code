//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 👍 836 👎 0

package leetcode.editor.cn;

//44:通配符匹配
public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new WildcardMatching().new Solution();
        System.out.println(solution.isMatch("adceb", "*a*b"));
        System.out.println(solution.isMatch("aaaa", "***a"));
        System.out.println(solution.isMatch("c", "*?*"));
        System.out.println(solution.isMatch("hi", "*?"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] flag;

        public boolean isMatch(String s, String p) {
            if (p.equals("") && s.equals("")) return true;
            if (p.equals("")) return false;
            if (s.equals("")) return !p.matches(".*[a-z?]+.*");
            char[] sArray = s.toCharArray();
            char[] pArray = p.toCharArray();
            boolean[] res = {false};
            flag = new boolean[sArray.length + 1][pArray.length + 1];
            isMatch(sArray, 0, pArray, 0, res);
            return res[0];
        }

        private void isMatch(char[] sArray, int p, char[] pArray, int q, boolean[] res) {
            if (p <= sArray.length && q <= pArray.length && flag[p][q])
                return;
            if (res[0])
                return;
            flag[p][q] = true;
            if (p == sArray.length && q == pArray.length) {
                res[0] = true;
                return;
            }
            if (p < sArray.length && q < pArray.length && (sArray[p] == pArray[q] || pArray[q] == '?')) {
                isMatch(sArray, p + 1, pArray, q + 1, res);
            } else if (q < pArray.length && pArray[q] == '*') {
                for (int i = 0; i <= sArray.length - p; i++) {
                    isMatch(sArray, p + i, pArray, q + 1, res);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}