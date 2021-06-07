//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 357 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//567:字符串的排列
public class PermutationInString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PermutationInString().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        Map<String, Integer> m1 = new HashMap<>(l1);
        if (l1 > l2) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            String ch = String.valueOf(s1.charAt(i));
            m1.put(ch, m1.get(ch) == null ? 1 : m1.get(ch) + 1);
        }
        int count = l2 - l1;
        for (int i = 0; i <= count; i++) {
            String str = s2.substring(i, i + l1);
            boolean bl = true;
            for (String ch : m1.keySet()) {
                String temp = str.replace(ch, "");
                if (l1 - temp.length() != m1.get(ch)) {
                    bl = false;
                    break;
                }
            }
            if (bl) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}