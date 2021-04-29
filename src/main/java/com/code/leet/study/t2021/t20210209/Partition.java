package com.code.leet.study.t2021.t20210209;

import com.code.leet.entiy.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Partition {
    /**
     * 86. 分隔链表
     */
    public ListNode partition(ListNode head, int x) {
        ListNode max = new ListNode(0);
        ListNode min = new ListNode(0);
        ListNode maxHead = max;
        ListNode minHead = min;
        while (head != null) {
            if (head.val >= x) {
                maxHead.next = head;
                maxHead = maxHead.next;
            } else {
                minHead.next = head;
                minHead = minHead.next;
            }
            head = head.next;
        }
        maxHead.next = null;
        minHead.next = max.next;
        return min.next;
    }
}
