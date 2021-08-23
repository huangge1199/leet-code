//一个 平方和三元组 (a,b,c) 指的是满足 a² + b² = c² 的 整数 三元组 a，b 和 c 。 
//
// 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：2
//解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
// 
//
// 示例 2： 
//
// 输入：n = 10
//输出：4
//解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 250 
// 
// Related Topics 数学 枚举 👍 5 👎 0

package leetcode.editor.cn;
//1925:统计平方和三元组的数目
class CountSquareSumTriples{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CountSquareSumTriples().new Solution();
    }
    
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i = n; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                int sum = i * i - j * j;
                int num = (int) Math.sqrt(sum);
                if (sum == num * num) {
                    count++;

                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}