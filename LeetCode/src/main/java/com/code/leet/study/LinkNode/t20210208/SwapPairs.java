package com.code.leet.study.LinkNode.t20210208;

import com.code.leet.entiy.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {
    /**
     * 24. 两两交换链表中的节点
     */
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = head.next;
//        head.next = swapPairs(newHead.next);
//        newHead.next = head;
//        return newHead;
//    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (head != null) {
            if(head.next==null){
                break;
            }
            ListNode after = head.next.next;
            ListNode next = head.next;

            head.next = after;
            next.next = head;

            temp.next = next;
            temp = temp.next.next;
            head = head.next;
        }
        return newHead.next;
    }

//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4);
//        ListNode head = new ListNode(list.get(0));
//        ListNode newHead = head;
//        for (int i = 1; i < list.size(); i++) {
//            newHead.next = new ListNode(list.get(i));
//            newHead = newHead.next;
//        }
//        swapPairs(head);
//    }
}
