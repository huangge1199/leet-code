//给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。 
//
// 示例 1： 
//
// 输入: "code"
//输出: false 
//
// 示例 2： 
//
// 输入: "aab"
//输出: true 
//
// 示例 3： 
//
// 输入: "carerac"
//输出: true 
// Related Topics 位运算 哈希表 字符串 👍 59 👎 0

package leetcode.editor.cn;

//266:回文排列
public class PalindromePermutation {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutation().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] arrs = new int[26];
            for (char ch : s.toCharArray()) {
                arrs[ch - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (arrs[i] % 2 == 1) {
                    if (count == 1) {
                        return false;
                    }
                    count++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
