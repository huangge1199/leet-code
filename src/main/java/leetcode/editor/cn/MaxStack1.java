//设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。 
//
// 实现 MaxStack 类： 
//
// 
// MaxStack() 初始化栈对象 
// void push(int x) 将元素 x 压入栈中。 
// int pop() 移除栈顶元素并返回这个元素。 
// int top() 返回栈顶元素，无需移除。 
// int peekMax() 检索并返回栈中最大元素，无需移除。 
// int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop",
// "top"]
//[[], [5], [1], [5], [], [], [], [], [], []]
//输出
//[null, null, null, null, 5, 5, 1, 5, 1, 5]
//
//解释
//MaxStack stk = new MaxStack();
//stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
//stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
//stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5, 1, 5] - 栈没有改变
//stk.popMax();  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
//stk.top();     // 返回 1，[5, 1] - 栈没有改变
//stk.peekMax(); // 返回 5，[5, 1] - 栈没有改变
//stk.pop();     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5] - 栈没有改变
// 
//
// 
//
// 提示： 
//
// 
// -107 <= x <= 107 
// 最多调用 104 次 push、pop、top、peekMax 和 popMax 
// 调用 pop、top、peekMax 或 popMax 时，栈中 至少存在一个元素 
// 
//
// 
//
// 进阶： 
//
// 
// 试着设计解决方案：调用 top 方法的时间复杂度为 O(1) ，调用其他方法的时间复杂度为 O(logn) 。 
// 
// Related Topics 栈 设计 链表 双向链表 有序集合 
// 👍 70 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//716:最大栈
public class MaxStack1 {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new MaxStack().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> max;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            stack = new Stack<>();
            max = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (max.isEmpty() || x > max.peek()) {
                max.push(x);
            } else {
                max.push(max.peek());
            }
        }

        public int pop() {
            max.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return max.peek();
        }

        public int popMax() {
            int num = max.peek();
            Stack<Integer> temp = new Stack<>();
            while (stack.peek() != num) {
                temp.push(pop());
            }
            pop();
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            return num;
        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
//leetcode submit region end(Prohibit modification and deletion)

}