package com.code.leet.study.t20200309;

import com.code.leet.entiy.ListNode;

/**
 * @Author: hyy
 * @Date: 2020-03-09 20:37
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        ListNode pPrev = null;
        while (p != null) {
            ListNode temp = p.next;
            if (temp == null) {
                newHead = p;
            }
            p.next = pPrev;
            pPrev = p;
            p = temp;
        }
        return newHead;
    }
}
