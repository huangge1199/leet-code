//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 10⁴。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 476 👎 0

package leetcode.editor.cn;

//424:替换后的最长重复字符
class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] num = new int[26];
            int max = 0;
            int index = 0;
            for (int i = 0;i<s.length();i++) {
                num[s.charAt(i) - 'A']++;
                max = Math.max(max, num[s.charAt(i) - 'A']);
                if (i - index + 1 - max > k) {
                    num[s.charAt(index) - 'A']--;
                    index++;
                }
            }
            return s.length() - index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}