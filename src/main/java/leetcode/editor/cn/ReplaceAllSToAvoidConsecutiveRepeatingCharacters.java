//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。 
//
// 注意：你 不能 修改非 '?' 字符。 
//
// 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。 
//
// 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。 
//
// 
//
// 示例 1： 
//
// 输入：s = "?zs"
//输出："azs"
//解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两
//个 'z' 。 
//
// 示例 2： 
//
// 输入：s = "ubv?w"
//输出："ubvaw"
//解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
// 
//
// 示例 3： 
//
// 输入：s = "j?qg??b"
//输出："jaqgacb"
// 
//
// 示例 4： 
//
// 输入：s = "??yw?ipkj?"
//输出："acywaipkja"
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 100 
// 
// 
// s 仅包含小写英文字母和 '?' 字符 
// 
// 
// Related Topics 字符串 👍 93 👎 0

package leetcode.editor.cn;

//1576:替换所有的问号
class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String modifyString(String s) {
            if (!s.contains("?")) {
                return s;
            }
            if (s.length() == 1) {
                return "a";
            }
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == '?') {
                    for (char j = 'a'; j < 'd'; j++) {
                        if (i == 0 && chs[i + 1] != j) {
                            chs[i] = j;
                            break;
                        }
                        if (i > 0 && i < chs.length - 1 && chs[i + 1] != j && chs[i - 1] != j) {
                            chs[i] = j;
                            break;
                        }
                        if (i == chs.length - 1 && chs[i - 1] != j) {
                            chs[i] = j;
                            break;
                        }
                    }
                }
            }
            StringBuilder sBuilder = new StringBuilder();
            for (char ch : chs) {
                sBuilder.append(ch);
            }
            s = sBuilder.toString();
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}