//给你一个字符串 s （下标从 0 开始）。你需要对 s 执行以下操作直到它变为一个有序字符串： 
//
// 
// 找到 最大下标 i ，使得 1 <= i < s.length 且 s[i] < s[i - 1] 。 
// 找到 最大下标 j ，使得 i <= j < s.length 且对于所有在闭区间 [i, j] 之间的 k 都有 s[k] < s[i - 1] 。 
// 交换下标为 i - 1 和 j 处的两个字符。 
// 将下标 i 开始的字符串后缀反转。 
// 
//
// 请你返回将字符串变成有序的最少操作次数。由于答案可能会很大，请返回它对 109 + 7 取余 的结果。 
//
// 
//
// 示例 1： 
//
// 输入：s = "cba"
//输出：5
//解释：模拟过程如下所示：
//操作 1：i=2，j=2。交换 s[1] 和 s[2] 得到 s="cab" ，然后反转下标从 2 开始的后缀字符串，得到 s="cab" 。
//操作 2：i=1，j=2。交换 s[0] 和 s[2] 得到 s="bac" ，然后反转下标从 1 开始的后缀字符串，得到 s="bca" 。
//操作 3：i=2，j=2。交换 s[1] 和 s[2] 得到 s="bac" ，然后反转下标从 2 开始的后缀字符串，得到 s="bac" 。
//操作 4：i=1，j=1。交换 s[0] 和 s[1] 得到 s="abc" ，然后反转下标从 1 开始的后缀字符串，得到 s="acb" 。
//操作 5：i=2，j=2。交换 s[1] 和 s[2] 得到 s="abc" ，然后反转下标从 2 开始的后缀字符串，得到 s="abc" 。
// 
//
// 示例 2： 
//
// 输入：s = "aabaa"
//输出：2
//解释：模拟过程如下所示：
//操作 1：i=3，j=4。交换 s[2] 和 s[4] 得到 s="aaaab" ，然后反转下标从 3 开始的后缀字符串，得到 s="aaaba" 。
//操作 2：i=4，j=4。交换 s[3] 和 s[4] 得到 s="aaaab" ，然后反转下标从 4 开始的后缀字符串，得到 s="aaaab" 。
// 
//
// 示例 3： 
//
// 输入：s = "cdbea"
//输出：63 
//
// 示例 4： 
//
// 输入：s = "leetcodeleetcodeleetcode"
//输出：982157772
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母。 
// 
// Related Topics 数学 字符串 
// 👍 1 👎 0

package leetcode.editor.cn;

//5720:使字符串有序的最少操作次数
public class MinimumNumberOfOperationsToMakeStringSorted {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumNumberOfOperationsToMakeStringSorted().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int makeStringSorted(String s) {
            int mode = 1000000007;
            long[] mul = new long[3000];
            long[] div = new long[3000];
            mul[0] = 1;
            for (int i = 1; i < 3000; i++) {
                mul[i] = mul[i - 1] * i % mode;
            }
            for (int i = 0; i < 3000; i++) {
                div[i] = power(mul[i], mode - 2, mode);
            }
            int[] cnt = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            long res = 0;
            for (int i = 0; i < length; i++) {
                int ch = s.charAt(i) - 'a';
                for (int j = 0; j < ch; j++) {
                    if (cnt[j] == 0) {
                        continue;
                    }
                    cnt[j]--;
                    long num = mul[length - 1 - i];
                    for (int k = 0; k < 26; k++) {
                        num = num * div[cnt[k]] % mode;
                    }
                    res = (res + num) % mode;
                    cnt[j]++;
                }
                cnt[ch]--;
            }
            return (int) res;
        }

        private long power(long num, int index, int mode) {
            if (index == 0) {
                return 1;
            }
            long res = power(num, index / 2, mode);
            res = res * res % mode;
            if (index % 2 == 1) {
                res = res * num % mode;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}