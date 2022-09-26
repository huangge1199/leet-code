//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 556 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//402:移掉K位数字
public class RemoveKDigits {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveKDigits().new Solution();
        //1219
        System.out.println(solution.removeKdigits("1432219", 3));
        //200
        System.out.println(solution.removeKdigits("10200", 1));
        //0
        System.out.println(solution.removeKdigits("10", 2));
        //0
        System.out.println(solution.removeKdigits("10", 1));
        //11
        System.out.println(solution.removeKdigits("112", 1));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) {
                return "0";
            }
            Stack<Character> stack = new Stack<>();
            int remove = 0;
            int i = 0;
            for (; i < num.length() - 1; i++) {
                while (i + 1 < num.length() && num.charAt(i) > num.charAt(i + 1) && remove < k) {
                    num = num.substring(i + 1);
                    i = 0;
                    remove++;
                    while (!stack.isEmpty() && i < num.length() && stack.peek() > num.charAt(i) && remove < k) {
                        stack.pop();
                        remove++;
                    }
                }
                if (remove == k) {
                    break;
                }
                if (i < num.length()) {
                    stack.push(num.charAt(i));
                }
            }
            num = num.substring(i);
            while (!stack.isEmpty()) {
                num = stack.pop() + num;
            }
            if (remove < k) {
                num = num.substring(0, num.length() - k + remove);
            }
            while (num.length() > 1 && num.startsWith("0")) {
                num = num.substring(1);
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}