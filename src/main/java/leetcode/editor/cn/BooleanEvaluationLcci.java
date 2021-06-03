//给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
// 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。 
//
// 示例 1: 
//
// 输入: s = "1^0|0|1", result = 0
//
//输出: 2
//解释: 两种可能的括号方法是
//1^(0|(0|1))
//1^((0|0)|1)
// 
//
// 示例 2: 
//
// 输入: s = "0&0&0&1^1|0", result = 1
//
//输出: 10 
//
// 提示： 
//
// 
// 运算符的数量不超过 19 个 
// 
// Related Topics 栈 字符串 
// 👍 43 👎 0

package leetcode.editor.cn;
//面试题 08.14:布尔运算
public class BooleanEvaluationLcci{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BooleanEvaluationLcci().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEval(String s, int result) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return (s.charAt(0) - '0') == result ? 1 : 0;
        }
        char[] ch = s.toCharArray();
        int[][][] dp = new int[ch.length][ch.length][2];
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0' || ch[i] == '1') {
                dp[i][i][ch[i] - '0'] = 1;
            }
        }
        for (int len = 2; len <= ch.length; len += 2) {
            for (int start = 0; start <= ch.length - len; start += 2) {
                int end = start + len;
                for (int k = start + 1; k <= end - 1; k += 2) {
                    if (ch[k] == '&') {
                        dp[start][end][0] += dp[start][k - 1][0] * dp[k + 1][end][0] + dp[start][k - 1][0] * dp[k + 1][end][1] + dp[start][k - 1][1] * dp[k + 1][end][0];
                        dp[start][end][1] += dp[start][k - 1][1] * dp[k + 1][end][1];
                    }
                    if (ch[k] == '|') {
                        dp[start][end][0] += dp[start][k - 1][0] * dp[k + 1][end][0];
                        dp[start][end][1] += dp[start][k - 1][0] * dp[k + 1][end][1] + dp[start][k - 1][1] * dp[k + 1][end][0] + dp[start][k - 1][1] * dp[k + 1][end][1];
                    }
                    if (ch[k] == '^') {
                        dp[start][end][0] += dp[start][k - 1][0] * dp[k + 1][end][0] + dp[start][k - 1][1] * dp[k + 1][end][1];
                        dp[start][end][1] += dp[start][k - 1][1] * dp[k + 1][end][0] + dp[start][k - 1][0] * dp[k + 1][end][1];
                    }
                }
            }
        }
        return dp[0][ch.length - 1][result];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}