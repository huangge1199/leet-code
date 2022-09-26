//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 209 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//345:反转字符串中的元音字母
class ReverseVowelsOfAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            int start = 0;
            int end = s.length() - 1;
            char[] chs = s.toCharArray();
            while (start < end) {
                if (list.contains(chs[start]) && list.contains(chs[end])) {
                    char ch = chs[start];
                    chs[start] = chs[end];
                    chs[end] = ch;
                    start++;
                    end--;
                }
                if (!list.contains(chs[start])) {
                    start++;
                }
                if (!list.contains(chs[end])) {
                    end--;
                }
            }
            return new String(chs);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}