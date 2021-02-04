package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

/**
 * @Author: hyy
 * @Date: 2020-01-26 02:53
 */

public class CountNodesII {
    /**
     * @param head:
     * @return: nothing
     */
    public int countNodesII(ListNode head) {
        int num = 0;
        while (head!=null){
            if(head.val>0&&head.val%2>0){
                num++;
            }
            head = head.next;
        }
        return num;
    }
}
