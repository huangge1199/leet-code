//给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。 
//
// 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：false
//解释：2 只有两个除数：1 和 2 。 
//
// 示例 2： 
//
// 输入：n = 4
//输出：true
//解释：4 有三个除数：1、2 和 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 数学 👍 9 👎 0

package leetcode.editor.cn;

//1952:三除数
class ThreeDivisors {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ThreeDivisors().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isThree(int n) {
            int flag = 0;
            if (n <= 2) {
                return false;
            }
            int num = n / 2;
            for (int i = 2; i <= num; i++) {
                if (n % i == 0) {
                    if (flag == 1) {
                        return false;
                    }
                    flag = 1;
                }
            }
            return flag == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}