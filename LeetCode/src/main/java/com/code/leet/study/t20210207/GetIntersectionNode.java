package com.code.leet.study.t20210207;

import com.code.leet.entiy.ListNode;

/**
 * 找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB, temp = null;
        while (pA != null || pB != null) {
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
            if (pA.val == pB.val && temp == null) {
                temp = pA;
            }
            if (pA.val != pB.val && temp != null) {
                temp = null;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return temp;
    }
}
