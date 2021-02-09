package com.code.leet.study.t20210209;

import com.code.leet.entiy.ListNode;
import org.omg.CORBA.FREE_MEM;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class DeleteDuplicates {
    /**
     * 82. 删除排序链表中的重复元素 II
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode front = new ListNode(-1);
        ListNode temp = front;
        int same = head.val;
        boolean flag = false;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                same = head.val;
                flag = true;
            } else if (flag && head.val == same) {
                head = head.next;
            } else {
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
        }
        if (head.val == same) {
            temp.next = null;
        } else {
            temp.next = head;
        }
        return front.next;
    }
}
