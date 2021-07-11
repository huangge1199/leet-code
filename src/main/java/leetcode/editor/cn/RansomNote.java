//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 160 👎 0

package leetcode.editor.cn;

//383:赎金信
class RansomNote {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RansomNote().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            int[] arr = new int[26];
            for (char ch : magazine.toCharArray()) {
                arr[ch - 'a']++;
            }
            for (char ch : ransomNote.toCharArray()) {
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