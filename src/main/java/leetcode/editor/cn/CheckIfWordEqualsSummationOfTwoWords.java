//字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。 
//
// 对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。 
//
// 
// 例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。 
// 
//
// 给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的
//小写英文字母组成。 
//
// 如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：firstWord = "acb", secondWord = "cba", targetWord = "cdb"
//输出：true
//解释：
//firstWord 的数值为 "acb" -> "021" -> 21
//secondWord 的数值为 "cba" -> "210" -> 210
//targetWord 的数值为 "cdb" -> "231" -> 231
//由于 21 + 210 == 231 ，返回 true
// 
//
// 示例 2： 
//
// 输入：firstWord = "aaa", secondWord = "a", targetWord = "aab"
//输出：false
//解释：
//firstWord 的数值为 "aaa" -> "000" -> 0
//secondWord 的数值为 "a" -> "0" -> 0
//targetWord 的数值为 "aab" -> "001" -> 1
//由于 0 + 0 != 1 ，返回 false 
//
// 示例 3： 
//
// 输入：firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
//输出：true
//解释：
//firstWord 的数值为 "aaa" -> "000" -> 0
//secondWord 的数值为 "a" -> "0" -> 0
//targetWord 的数值为 "aaaa" -> "0000" -> 0
//由于 0 + 0 == 0 ，返回 true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= firstWord.length, secondWord.length, targetWord.length <= 8 
// firstWord、secondWord 和 targetWord 仅由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。 
// 
// Related Topics 字符串 
// 👍 4 👎 0

package leetcode.editor.cn;
//1880:检查某单词是否等于两单词之和
public class CheckIfWordEqualsSummationOfTwoWords{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CheckIfWordEqualsSummationOfTwoWords().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return trans(firstWord) + trans(secondWord) == trans(targetWord);
        }

        private int trans(String str) {
            while (str.length() > 1 && str.startsWith("a")) {
                str = str.substring(1);
            }
            StringBuilder numStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                numStr.append(str.charAt(i) - 'a');
            }
            return Integer.parseInt(numStr.toString());
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}