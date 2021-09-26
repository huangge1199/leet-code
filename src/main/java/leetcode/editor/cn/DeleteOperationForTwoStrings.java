//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 👍 215 👎 0

package leetcode.editor.cn;

//583:两个字符串的删除操作
class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int minDistance(String word1, String word2) {
//            return word1.length() + word2.length() - 2 * maxString(word1, word2, word1.length(), word2.length());
//        }
//
//        private int maxString(String word1, String word2, int index1, int index2) {
//            if (index1 == 0 || index2 == 0) {
//                return 0;
//            } else if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
//                return 1 + maxString(word1, word2, index1 - 1, index2 - 1);
//            } else {
//                return Math.max(maxString(word1, word2, index1 - 1, index2), maxString(word1, word2, index1, index2 - 1));
//            }
//        }
        public int minDistance(String word1, String s2) {
            int[][] dp = new int[word1.length() + 1][s2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 || j == 0) {
                        continue;
                    }
                    if (word1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return word1.length() + s2.length() - 2 * dp[word1.length()][s2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}