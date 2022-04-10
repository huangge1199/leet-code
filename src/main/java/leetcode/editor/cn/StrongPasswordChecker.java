//
//如果一个密码满足下述所有条件，则认为这个密码是强密码：
//
// 
// 由至少 6 个，至多 20 个字符组成。 
// 至少包含 一个小写 字母，一个大写 字母，和 一个数字 。 
// 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以算是强密码)。 
// 
//
// 给你一个字符串 password ，返回 将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 
//。 
//
// 在一步修改操作中，你可以： 
//
// 
// 插入一个字符到 password ， 
// 从 password 中删除一个字符，或 
// 用另一个字符来替换 password 中的某个字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：password = "a"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：password = "aA1"
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：password = "1337C0d3"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= password.length <= 50 
// password 由字母、数字、点 '.' 或者感叹号 '!' 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 138 👎 0

package leetcode.editor.cn;

//420:强密码检验器
public class StrongPasswordChecker {
    public static void main(String[] args) {
        Solution solution = new StrongPasswordChecker().new Solution();
        // TO TEST
        solution.strongPasswordChecker("aaa111");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strongPasswordChecker(String password) {
            char[] cs = password.toCharArray();
            int n = cs.length;

            // 计算字符种类
            int A = 0, B = 0, C = 0;
            for (char c : cs) {
                if (c >= 'a' && c <= 'z') {
                    A = 1;
                } else if (c >= '0' && c <= '9') {
                    B = 1;
                } else if (c >= 'A' && c <= 'Z') {
                    C = 1;
                }
            }
            int m = A + B + C;

            // 情况1
            if (n < 6) {
                return Math.max(6 - n, 3 - m);
            }
            // 情况2
            else if (n <= 20) {
                // 需要替换的次数
                int tot = 0;
                // 采用双指针的方式求出超三连字符
                for (int i = 0; i < n; ) {
                    int j = i;
                    while (j < n && cs[j] == cs[i]) {
                        j++;
                    }
                    int l = j - i;
                    if (l >= 3) {
                        tot += l / 3;
                    }
                    i = j;
                }
                return Math.max(tot, 3 - m);
            } else {
                int tot = 0;
                int[] counts = new int[3];
                for (int i = 0; i < n; ) {
                    int j = i;
                    while (j < n && cs[j] == cs[i]) {
                        j++;
                    }
                    int l = j - i;
                    // 同时统计 需要替换的次数 与 l%3
                    if (l >= 3) {
                        tot += l / 3;
                        counts[l % 3]++;
                    }
                    i = j;
                }
                // base，不管怎么样都要删这么多次
                int base = n - 20, cur = base;
                for (int i = 0; i < 3; i++) {
                    // l%3==2 的情况，因为l%3==0和l%3==0的情况在删去只会就会变成l%3==2，同时每改一次等价于删除3次，所以替代
                    if (i == 2) {
                        counts[i] = tot;
                    }
                    if (counts[i] != 0 && cur != 0) {
                        // 对于 l%3==i 的数来说， 要删的个数就是 counts[i] * (i + 1)
                        int t = Math.min(counts[i] * (i + 1), cur);
                        cur -= t;
                        // 每减少一个删去一个 i+1 ，都可以少修改一次
                        tot -= t / (i + 1);
                    }
                }
                return base + Math.max(tot, 3 - m);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
