package com.code.lint.y2020.m02.d11;

import java.util.Stack;

/**
 * 12. 带最小值操作的栈
 *
 * 实现一个栈, 支持以下操作:
 *
 *     push(val) 将 val 压入栈
 *     pop() 将栈顶元素弹出, 并返回这个弹出的元素
 *     min() 返回栈中元素的最小值
 *
 * 要求 O(1) 开销.
 *
 * @Author: hyy
 * @Date: 2020-02-11 21:46
 */

public class MinStack {
    public MinStack() {
        // do intialization if necessary
    }

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        int top;
        if (!minstack.empty()) {
            top = minstack.peek();
        } else {
            top = number;
        }
        if (number < top) {
            minstack.push(number);
        } else {
            minstack.push(top);
        }
    }

    /**
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int data = 0;
        if(!stack.empty()){
            data = stack.peek();
            stack.pop();
            minstack.pop();
        }
        return data;
    }

    /**
     * @return: An integer
     */
    public int min() {
        // write your code here
        int data = 0;
        if(!minstack.empty()){
            data = minstack.peek();
        }
        return data;
    }
}
