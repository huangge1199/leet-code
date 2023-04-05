////给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 28 👎 0


package leetcode.editor.cn;

// 2427:公因子的数目
public class NumberOfCommonFactors {
    public static void main(String[] args) {
        Solution solution = new NumberOfCommonFactors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int cnt = 0;
            while (a != b) {
                int sub = Math.abs(a - b);
                a = Math.min(a, b);
                b = sub;
            }
            for (int i = 1; i * i <= a; i++) {
                if (a % i == 0) {
                    if (a / i == i) {
                        cnt++;
                    } else {
                        cnt += 2;
                    }
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}