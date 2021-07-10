//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 300 👎 0

package leetcode.editor.cn;

//557:反转字符串中的单词 III
public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            StringBuilder str = new StringBuilder();
            StringBuilder ss = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch != ' ') {
                    str.append(ch);
                } else {
                    ss.append(str.reverse()).append(" ");
                    str = new StringBuilder();
                }
            }
            ss.append(str.reverse());
            return ss.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}