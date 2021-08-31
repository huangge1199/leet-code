//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 282 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//784:字母大小写全排列
class LetterCasePermutation {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LetterCasePermutation().new Solution();
        solution.letterCasePermutation("a1b2");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            return dfs(s, 0);
        }

        private List<String> dfs(String str, int index) {
            List<String> result = new ArrayList<>();
            if (index == str.length() - 1) {
                String s1 = ("" + str.charAt(index)).toLowerCase();
                String s2 = ("" + str.charAt(index)).toUpperCase();
                if (s1.equals(s2)) {
                    result.add(s1);
                } else {
                    result.add(s1);
                    result.add(s2);
                }
            } else {
                List<String> rest = dfs(str, index + 1);
                String s1 = ("" + str.charAt(index)).toLowerCase();
                String s2 = ("" + str.charAt(index)).toUpperCase();
                for (String r : rest) {
                    if (s1.equals(s2)) {
                        result.add(s1 + r);
                    } else {
                        result.add(s1 + r);
                        result.add(s2 + r);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}