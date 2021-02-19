package com.code.leet.study.t2021.t20210207;

import com.code.leet.entiy.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = head;
        ListNode pro = head;
        while (temp.val == val) {
            head = pro = temp = head.next;
        }
        temp = temp.next;
        while (temp != null) {
            if (temp.val == val) {
                pro.next = temp.next;
            }else{
                pro = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
