//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3593 👎 0

package leetcode.editor.cn;

import java.util.Collections;

//5:最长回文子串
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestPalindromicSubstring().new Solution();
        //bab
        System.out.println(solution.longestPalindrome("babad"));
        //bb
        System.out.println(solution.longestPalindrome("cbbd"));
        //a
        System.out.println(solution.longestPalindrome("a"));
        //a
        System.out.println(solution.longestPalindrome("ac"));
        //ccc
        System.out.println(solution.longestPalindrome("ccc"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            boolean[][] bl = new boolean[length][length];
            for (int i = 0; i < length; i++) {
                bl[i][i] = true;
            }
            int index = 0;
            int max = 1;
            for (int i = 2; i <= length; i++) {
                for (int start = 0; start < length && i + start - 1 < length; start++) {
                    int end = i + start - 1;
                    if (s.charAt(start) != s.charAt(end)) {
                        bl[start][end] = false;
                    } else {
                        if (i <= 3) {
                            bl[start][end] = true;
                        } else {
                            bl[start][end] = bl[start + 1][end - 1];
                        }
                    }

                    if (bl[start][end] && i > max) {
                        max = i;
                        index = start;
                    }
                }
            }
            return s.substring(index, index + max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}