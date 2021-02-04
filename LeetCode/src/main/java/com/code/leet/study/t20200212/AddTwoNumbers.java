package com.code.leet.study.t20200212;

import com.code.leet.entiy.ListNode;

/**
 * 2. 两数相加
 *
 * @Author: hyy
 * @Date: 2020-02-12 14:35
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, p = head = new ListNode(0);
        int flag = 0;
        int val;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            val = (l1.val + flag) % 10;
            flag = (l1.val + flag) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            val = (l2.val + flag) % 10;
            flag = (l2.val + flag) / 10;
            p.next = new ListNode(val);
            p = p.next;
            l2 = l2.next;
        }
        if (flag == 1) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
}
