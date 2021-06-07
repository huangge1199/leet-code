//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。 
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
// Related Topics 字符串 
// 👍 2 👎 0

package leetcode.editor.cn;
//1796:字符串中第二大的数字
public class SecondLargestDigitInAString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SecondLargestDigitInAString().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int second = -2;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            String temp;
            temp = i + 1 < size ? s.substring(i, i + 1) : s.substring(i);
            if (temp.matches("[0-9]+")) {
                int cur = Integer.parseInt(temp);
                if (cur > max) {
                    second = max;
                    max = cur;
                } else if (cur > second && cur != max) {
                    second = cur;
                }
            }
        }
        return second >= 0 ? second : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}