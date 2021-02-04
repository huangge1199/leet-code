package com.code.lint.y2020.m02.d11;

import java.util.Stack;

/**
 * 229. 栈排序
 *
 * 请设计一种方法将一个栈进行升序排列 （最大的数在最上面）。
 *
 * 你可以使用另外一个栈来辅助操作，但不可将这些数复制到另外一个数据结构中 （如，数组）。
 *
 * @Author: hyy
 * @Date: 2020-02-11 22:46
 */

public class StackSorting {
    /*
     * @param stk: an integer stack
     * @return: void
     */
    public void stackSorting(Stack<Integer> stk) {
        // write your code here
        Stack<Integer> temp = new Stack<>();
        while (!stk.isEmpty()) {
            if(temp.isEmpty()){
                temp.push(stk.pop());
            }else{
                int data = stk.pop();
                while(!temp.isEmpty()&&temp.peek()<data){
                    stk.push(temp.pop());
                }
                temp.push(data);
            }
        }
        while (!temp.isEmpty()){
            stk.push(temp.pop());
        }
    }
}
