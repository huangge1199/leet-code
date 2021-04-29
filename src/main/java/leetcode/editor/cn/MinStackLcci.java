//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 41 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//面试题 03.02:栈的最小值
public class MinStackLcci {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new MinStackLcci().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        class Data {
            int num;
            int min;

            public Data(int num, int min) {
                this.num = num;
                this.min = min;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        Stack<Data> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Data(val,val));
            } else {
                stack.push(new Data(val, Math.min(val, stack.peek().min)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().num;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}