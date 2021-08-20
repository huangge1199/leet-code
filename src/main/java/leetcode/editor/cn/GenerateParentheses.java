//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 1970 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//22:括号生成
class GenerateParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GenerateParentheses().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(n,0,"",result);
            return result;
        }

        private void dfs(int left, int right, String str, List<String> result) {
            if (left == 0 && right == 0) {
                result.add(str);
            }
            if (left > 0) {
                dfs(left - 1, right + 1, str + "(", result);
            }
            if (right > 0) {
                dfs(left, right - 1, str + ")", result);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}