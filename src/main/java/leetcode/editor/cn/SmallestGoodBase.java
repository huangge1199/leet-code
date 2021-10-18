//对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。 
//
// 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。 
//
// 
//
// 示例 1： 
//
// 
//输入："13"
//输出："3"
//解释：13 的 3 进制是 111。
// 
//
// 示例 2： 
//
// 
//输入："4681"
//输出："8"
//解释：4681 的 8 进制是 11111。
// 
//
// 示例 3： 
//
// 
//输入："1000000000000000000"
//输出："999999999999999999"
//解释：1000000000000000000 的 999999999999999999 进制是 11。
// 
//
// 
//
// 提示： 
//
// 
// n的取值范围是 [3, 10^18]。 
// 输入总是有效且没有前导 0。 
// 
//
// 
// Related Topics 数学 二分查找 
// 👍 71 👎 0

package leetcode.editor.cn;

//483:最小好进制
public class SmallestGoodBase {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SmallestGoodBase().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestGoodBase(String n) {
            long num = Long.parseLong(n);
            int mMax = (int) Math.floor(Math.log(num) / Math.log(2));
            for (int m = mMax; m > 1; m--) {
                int k = (int) Math.pow(num, 1.0 / m);
                long mul = 1, sum = 1;
                for (int i = 0; i < m; i++) {
                    mul *= k;
                    sum += mul;
                }
                if (sum == num) {
                    return Integer.toString(k);
                }
            }
            return Long.toString(num - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}