//给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。 
//
// 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。 
//
// 任意两个字符都可以进行交换，不必相邻 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "111000"
//输出：1
//解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "010"
//输出：0
//解释：字符串已经是交替字符串了，不需要交换。
// 
//
// 示例 3： 
//
// 
//输入：s = "1110"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 的值为 '0' 或 '1' 
// 
// Related Topics 贪心算法 
// 👍 8 👎 0

package leetcode.editor.cn;

//1864:构成交替字符串需要的最小交换次数
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumNumberOfSwapsToMakeTheBinaryStringAlternating().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwaps(String s) {
            int s0 = s.replace("0", "").length();
            int s1 = s.replace("1", "").length();
            if (Math.abs(s0 - s1) > 1) {
                return -1;
            }
            int com = 0;
            int m0 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (com != s.charAt(i) - '0') {
                    m0++;
                }
                com = 1 - com;
            }
            m0 = m0 % 2 == 0 ? m0 : Integer.MAX_VALUE;
            com = 1;
            int m1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (com != s.charAt(i) - '0') {
                    m1++;
                }
                com = 1 - com;
            }
            m1 = m1 % 2 == 0 ? m1 : Integer.MAX_VALUE;
            return Math.min(m0, m1) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}