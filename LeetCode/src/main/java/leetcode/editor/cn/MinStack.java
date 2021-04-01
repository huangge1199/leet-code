//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 856 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//155:最小栈
public class MinStack {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new MinStack().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        //        Stack<Integer> stack;
//        Stack<Integer> min;
//        public MinStack() {
//            stack = new Stack<>();
//            min = new Stack<>();
//        }
//        public void push(int val) {
//            if (stack.isEmpty()) {
//                min.push(val);
//            } else {
//                min.push(Math.min(min.peek(),val));
//            }
//            stack.push(val);
//        }
//        public void pop() {
//            stack.pop();
//            min.pop();
//        }
//        public int top() {
//            return stack.peek();
//        }
//        public int getMin() {
//            return min.peek();
//        }
        class Data{
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
                stack.push(new Data(val,Math.min(val,stack.peek().min)));
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
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}