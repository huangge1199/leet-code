//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 132 👎 0

package leetcode.editor.cn;

import java.util.*;

//159:至多包含两个不同字符的最长子串
class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if (n < 3) return n;
            int left = 0;
            int right = 0;
            Map<Character, Integer> hashmap = new HashMap<>();

            int max_len = 2;

            while (right < n) {
                if (hashmap.size() < 3)
                    hashmap.put(s.charAt(right), right++);
                if (hashmap.size() == 3) {
                    int del_idx = Collections.min(hashmap.values());
                    hashmap.remove(s.charAt(del_idx));
                    // move left pointer of the slidewindow
                    left = del_idx + 1;
                }

                max_len = Math.max(max_len, right - left);
            }
            return max_len;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}