//给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。 
//
// 返回使 t 成为 s 的字母异位词的最小步骤数。 
//
// 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。 
//
// 
//
// 示例 1： 
//
// 输出：s = "bab", t = "aba"
//输出：1
//提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
// 
//
// 示例 2： 
//
// 输出：s = "leetcode", t = "practice"
//输出：5
//提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
// 
//
// 示例 3： 
//
// 输出：s = "anagram", t = "mangaar"
//输出：0
//提示："anagram" 和 "mangaar" 本身就是一组字母异位词。 
// 
//
// 示例 4： 
//
// 输出：s = "xxyyzz", t = "xxyyzz"
//输出：0
// 
//
// 示例 5： 
//
// 输出：s = "friend", t = "family"
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50000 
// s.length == t.length 
// s 和 t 只包含小写英文字母 
// 
// Related Topics 字符串 
// 👍 24 👎 0

package leetcode.editor.cn;

//1347:制造字母异位词的最小步骤数
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumNumberOfStepsToMakeTwoStringsAnagram().new Solution();
        solution.minSteps("anagram", "mangaar");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(String s, String t) {
            int[] arr = new int[26];
            int length = s.length();
            int num = 0;
            for (int i = 0; i < length; i++) {
                if (arr[s.charAt(i) - 'a'] >= 0) {
                    num++;
                }
                arr[s.charAt(i) - 'a']++;
                if (arr[t.charAt(i) - 'a'] > 0) {
                    num--;
                }
                arr[t.charAt(i) - 'a']--;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}