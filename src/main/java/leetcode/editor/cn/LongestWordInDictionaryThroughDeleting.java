//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 214 👎 0

package leetcode.editor.cn;

import java.util.*;

//524:通过删除字母匹配到字典里最长单词
class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort((o1, o2) -> o2.length() != o1.length() ? o2.length() - o1.length() : o1.compareTo(o2));
            for (String str : dictionary) {
                int i = 0, j = 0;
                while (i < str.length() && j < s.length()) {
                    if (str.charAt(i) == s.charAt(j)) {
                        i++;
                    }
                    j++;
                }
                if (i == str.length()) {
                    return str;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}