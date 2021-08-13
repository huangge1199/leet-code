//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 278 👎 0

package leetcode.editor.cn;

//233:数字 1 的个数
class NumberOfDigitOne {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NumberOfDigitOne().new Solution();
        //4
        System.out.println(solution.countDigitOne(11));
        //6
        System.out.println(solution.countDigitOne(13));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countDigitOne(int n) {
            int index = 1;
            int count = 0;
            while (index<=n){
                count += (n / (index * 10)) * index + Math.min(Math.max(n % (index * 10) - index + 1, 0), index);
                index *= 10;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}