//反转 一个整数意味着倒置它的所有位。 
//
// 
// 例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。 
// 
//
// 给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。如果 reversed2 等于
// num ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：num = 526
//输出：true
//解释：反转 num 得到 625 ，接着反转 625 得到 526 ，等于 num 。
// 
//
// 示例 2： 
//
// 输入：num = 1800
//输出：false
//解释：反转 num 得到 81 ，接着反转 81 得到 18 ，不等于 num 。 
//
// 示例 3： 
//
// 输入：num = 0
//输出：true
//解释：反转 num 得到 0 ，接着反转 0 得到 0 ，等于 num 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10⁶ 
// 
// 👍 1 👎 0

package leetcode.editor.cn;

//5963:反转两次的数字
class ANumberAfterADoubleReversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ANumberAfterADoubleReversal().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSameAfterReversals(int num) {
            return num == 0 || num % 10 > 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}