//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1932 👎 0

package leetcode.editor.cn;

//Java：14:最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }
            int n1 = strs[0].length();
            int n2 = strs[1].length();
            int index = 0;
            String sameStr = "";
            while (index < n1 && index < n2) {
                if (strs[0].charAt(index) == strs[1].charAt(index)) {
                    sameStr += strs[0].charAt(index);
                    index++;
                } else {
                    break;
                }
            }
            for (int i = 2; i < strs.length; i++) {
                while (!"".equals(sameStr)) {
                    if (strs[i].startsWith(sameStr)) {
                        break;
                    }
                    sameStr = sameStr.substring(0, sameStr.length() - 1);
                }
                if ("".equals(sameStr)) {
                    return "";
                }
            }
            return sameStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
