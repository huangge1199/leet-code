//给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所
//有能够得到目标值的表达式。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = "123", target = 6
//输出: ["1+2+3", "1*2*3"] 
// 
//
// 示例 2: 
//
// 
//输入: num = "232", target = 8
//输出: ["2*3+2", "2+3*2"] 
//
// 示例 3: 
//
// 
//输入: num = "105", target = 5
//输出: ["1*0+5","10-5"] 
//
// 示例 4: 
//
// 
//输入: num = "00", target = 0
//输出: ["0+0", "0-0", "0*0"]
// 
//
// 示例 5: 
//
// 
//输入: num = "3456237490", target = 9191
//输出: [] 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10 
// num 仅含数字 
// -2³¹ <= target <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 回溯 👍 324 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//282:给表达式添加运算符
class ExpressionAddOperators {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ExpressionAddOperators().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        String num;
        int target;
        List<String> ans;

        public List<String> addOperators(String num, int target) {
            this.n = num.length();
            this.num = num;
            this.target = target;
            this.ans = new ArrayList<>();
            StringBuffer expr = new StringBuffer();
            backtrack(expr, 0, 0, 0);
            return ans;
        }

        public void backtrack(StringBuffer expr, int i, long res, long mul) {
            if (i == n) {
                if (res == target) {
                    ans.add(expr.toString());
                }
                return;
            }
            int signIndex = expr.length();
            if (i > 0) {
                expr.append(0);
            }
            long val = 0;
            for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
                val = val * 10 + num.charAt(j) - '0';
                expr.append(num.charAt(j));
                if (i == 0) {
                    backtrack(expr, j + 1, val, val);
                } else {
                    expr.setCharAt(signIndex, '+');
                    backtrack(expr, j + 1, res + val, val);
                    expr.setCharAt(signIndex, '-');
                    backtrack(expr, j + 1, res - val, -val);
                    expr.setCharAt(signIndex, '*');
                    backtrack(expr, j + 1, res - mul + mul * val, mul * val);
                }
            }
            expr.setLength(signIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}