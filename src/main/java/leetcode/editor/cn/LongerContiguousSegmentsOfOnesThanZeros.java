//给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 fa
//lse 。 
//
// 
// 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。 
// 
//
// 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1101"
//输出：true
//解释：
//由 1 组成的最长连续子字符串的长度是 2："1101"
//由 0 组成的最长连续子字符串的长度是 1："1101"
//由 1 组成的子字符串更长，故返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：s = "111000"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 3："111000"
//由 0 组成的最长连续子字符串的长度是 3："111000"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：s = "110100010"
//输出：false
//解释：
//由 1 组成的最长连续子字符串的长度是 2："110100010"
//由 0 组成的最长连续子字符串的长度是 3："110100010"
//由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s[i] 不是 '0' 就是 '1' 
// 
// Related Topics 数组 双指针 
// 👍 7 👎 0

package leetcode.editor.cn;
//1869:哪种连续子字符串更长
public class LongerContiguousSegmentsOfOnesThanZeros{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongerContiguousSegmentsOfOnesThanZeros().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkZeroOnes(String s) {
        if (s.length() == 0 || !s.contains("1")) {
            return false;
        }
        if (!s.contains("0")) {
            return true;
        }
        int[] lengths = new int[2];
        int start0 = s.indexOf("0");
        int start1 = s.indexOf("1");
        int[] maxs = new int[2];
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                lengths[ch - '0']++;
            } else {
                maxs[ch - '0'] = Math.max(maxs[ch - '0'], lengths[ch - '0']);
                lengths[ch - '0'] = 0;
                ch = s.charAt(i);
                lengths[ch - '0']++;
            }
        }
        maxs[ch - '0'] = Math.max(maxs[ch - '0'], lengths[ch - '0']);
        return maxs[1]>maxs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}