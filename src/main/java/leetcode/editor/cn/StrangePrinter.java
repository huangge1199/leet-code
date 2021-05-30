//有台奇怪的打印机有以下两个特殊要求： 
//
// 
// 打印机每次只能打印由 同一个字符 组成的序列。 
// 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。 
// 
//
// 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabbb"
//输出：2
//解释：首先打印 "aaa" 然后打印 "bbb"。
// 
//
// 示例 2： 
//
// 
//输入：s = "aba"
//输出：2
//解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 162 👎 0

package leetcode.editor.cn;

//664:奇怪的打印机
public class StrangePrinter {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new StrangePrinter().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strangePrinter(String s) {
            int length = s.length();
            int[][] dp = new int[length][length];
//            for (int i = 0; i < length; i++) {
//                dp[i][i] = 1;
//            }
            for (int i = length - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k <= j - 1; k++) {
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = min;
                    }
                }
            }
            return dp[0][length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}