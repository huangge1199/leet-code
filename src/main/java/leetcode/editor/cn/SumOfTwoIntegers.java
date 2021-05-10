//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 393 👎 0

package leetcode.editor.cn;

//371:两整数之和
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SumOfTwoIntegers().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getSum(int a, int b) {
            while(b != 0){
                int temp = a ^ b;
                b = (a & b) << 1;
                a = temp;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}