//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 401 👎 0

package leetcode.editor.cn;

//242:有效的字母异位词
class ValidAnagram {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidAnagram().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] arr = new int[26];
            for (char ch : s.toCharArray()) {
                arr[ch - 'a']++;
            }
            for (char ch : t.toCharArray()) {
                if (arr[ch - 'a'] < 1) {
                    return false;
                }
                arr[ch - 'a']--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}