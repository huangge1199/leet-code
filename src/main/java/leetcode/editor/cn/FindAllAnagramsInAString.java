//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 586 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//438:找到字符串中所有字母异位词
class FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if(p.length()>s.length()){
                return new ArrayList<>();
            }
            int[] pchs = new int[26];
            for (char ch : p.toCharArray()) {
                pchs[ch - 'a']++;
            }
            char[] schs = s.toCharArray();
            int start = 0;
            int[] chs = new int[26];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < p.length() - 1; i++) {
                chs[schs[i] - 'a']++;
            }
            for (int i = p.length() - 1; i < schs.length; i++) {
                chs[schs[i] - 'a']++;
                if (Arrays.equals(pchs, chs)) {
                    list.add(start);
                }
                chs[schs[start] - 'a']--;
                start++;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}