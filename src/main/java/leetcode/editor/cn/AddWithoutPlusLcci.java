//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 70 👎 0

package leetcode.editor.cn;

//面试题 17.01:不用加号的加法
public class AddWithoutPlusLcci {
    public static void main(String[] args) {
        Solution solution = new AddWithoutPlusLcci().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {
            if (b == 0) return a;
            return add(a ^ b, (a & b) << 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}