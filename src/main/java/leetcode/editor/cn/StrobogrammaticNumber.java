//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。 
//
// 
//
// 示例 1: 
//
// 输入: num = "69"
//输出: true
// 
//
// 示例 2: 
//
// 输入: num = "88"
//输出: true 
//
// 示例 3: 
//
// 输入: num = "962"
//输出: false 
//
// 示例 4： 
//
// 输入：num = "1"
//输出：true
// 
// Related Topics 哈希表 双指针 字符串 👍 40 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//246:中心对称数
public class StrobogrammaticNumber {
    public static void main(String[] args) {
        Solution solution = new StrobogrammaticNumber().new Solution();
        solution.isStrobogrammatic("69");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStrobogrammatic(String num) {
            List<Character> list = new ArrayList<>();
            list.add('2');
            list.add('3');
            list.add('4');
            list.add('5');
            list.add('7');
            for (Character character : list) {
                if (num.contains("" + character)) {
                    return false;
                }
            }
            int mid = (num.length() + 1) / 2;
            for (int i = 0; i < mid; i++) {
                if (num.length() % 2 == 1 && i == mid - 1) {
                    if (num.charAt(i) != '1' && num.charAt(i) != '0' && num.charAt(i) != '8') {
                        return false;
                    }
                }
                char ch = num.charAt(i);
                if (ch == '0' || ch == '1' || ch == '8') {
                    if (num.charAt(num.length() - 1 - i) != ch) {
                        return false;
                    }
                }
                if (ch == '6' && num.charAt(num.length() - 1 - i) != '9') {
                    return false;
                }
                if (ch == '9' && num.charAt(num.length() - 1 - i) != '6') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}