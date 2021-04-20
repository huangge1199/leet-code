//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 800 👎 0

package leetcode.editor.cn;

//28:实现 strStr()
public class ImplementStrstr {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ImplementStrstr().new Solution();
//        solution.strStr("aaaaa", "bba");
//        solution.strStr("mississippi", "mississippi");
        System.out.println(solution.strStr("mississippi", "issip"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
            if ("".equals(needle)) {
                return 0;
            }
            if ("".equals(haystack)) {
                return -1;
            }
            char[] hay = haystack.toCharArray();
            char[] need = needle.toCharArray();
            int hSize = hay.length;
            int nSize = need.length;
            int result = 0;
            int index = -1;
            for (int i = 0; i <= hSize - nSize; i++) {
                int temp = i;
                for (char c : need) {
                    if (hay[i] == c) {
                        if (result == 0) {
                            index = i;
                        }
                        result++;
                        i++;
                    } else {
                        result = 0;
                        index = -1;
                        break;
                    }
                }
                i = temp;
                if (result == nSize) {
                    break;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}