//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 148 👎 0

package leetcode.editor.cn;

//504:七进制数
public class Base7 {
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            boolean bl = num < 0;
            num = Math.abs(num);
            StringBuilder str = new StringBuilder();
            while (num >= 7) {
                str.insert(0, num % 7);
                num /= 7;
            }
            str.insert(0, num);
            if (bl) {
                str.insert(0, '-');
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
