//给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。 
//
// 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 34, k = 6
//输出：9
//解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
// 
//
// 示例 2： 
//
// 
//输入：n = 10, k = 10
//输出：1
//解释：n 本身就是 10 进制。 1 + 0 = 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 2 <= k <= 10 
// 
// Related Topics 位运算 数学 
// 👍 0 👎 0

package leetcode.editor.cn;
//5738:K 进制表示下的各位数字总和
public class SumOfDigitsInBaseK{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SumOfDigitsInBaseK().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        String str = "";
        while (n > 0) {
            str += n % k;
            n /= k;
        }
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}