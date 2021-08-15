//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。 
//
// 
//
// 注意：n 是正数且在 32 位整数范围内（n < 231）。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
// Related Topics 数学 二分查找 
// 👍 170 👎 0

package leetcode.editor.cn;
//400:第 N 位数字
class NthDigit{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NthDigit().new Solution();
    }
    
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int[] ant = new int[]{0, 10, 190, 2890, 38890, 488890, 5888890, 68888890, 788888890};
        int[] numBegin = new int[]{0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        for(int i = ant.length - 1; i >= 0; i--){
            if(n >= ant[i]){
                int num = (n - ant[i]) / (i + 1) + numBegin[i];
                int posi = (n - ant[i]) % (i + 1);
                return num % (int)Math.pow(10, i + 1 - posi) / (int)Math.pow(10,  i - posi);
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}