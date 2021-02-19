package com.code.leet.study.t2021.t20210207;

import com.code.leet.entiy.ListNode;

/**
 * 找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        if(pA == null || pB == null){
            return null;
        }
        while (pA != null || pB != null) {
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode node1A = new ListNode(1);
        ListNode node1B = new ListNode(1);
        ListNode node8 = new ListNode(4);

        headA.next = node1A;
        node1A.next=node8;

        headB.next=node1B;
        node1B.next=node8;
    }
}
