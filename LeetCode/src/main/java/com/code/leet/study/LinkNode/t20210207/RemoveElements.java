package com.code.leet.study.LinkNode.t20210207;

import com.code.leet.entiy.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 */
public class RemoveElements {
    /**
     * 203. 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        if (temp == null) {
            return head;
        }
        while (temp.val == val) {
            head = temp = temp.next;
            if (temp == null) {
                return head;
            }
        }
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
