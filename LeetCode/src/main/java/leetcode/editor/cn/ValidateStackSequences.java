//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
// Related Topics 栈 
// 👍 175 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//946:验证栈序列
public class ValidateStackSequences {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidateStackSequences().new Solution();
        //true
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        //false
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            for (int i = 0; i < popped.length; i++) {
                if (j == pushed.length) {
                    return false;
                }
                while (j < pushed.length && popped[i] != pushed[j]) {
                    stack.push(pushed[j]);
                    j++;
                    if (j == pushed.length) {
                        return false;
                    }
                }
                j++;
                while (!stack.isEmpty() && i < popped.length - 1 && popped[i + 1] == stack.peek()) {
                    stack.pop();
                    i++;
                }
            }
            return true;
//            // 官方
//            int N = pushed.length;
//            Stack<Integer> stack = new Stack<>();
//
//            int j = 0;
//            for (int x : pushed) {
//                stack.push(x);
//                while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
//                    stack.pop();
//                    j++;
//                }
//            }
//
//            return j == N;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}