package com.code.leet.study.t20210208;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {
    /**
     * 61. 旋转链表
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        k = k % list.size();
        if (k == 0) {
            return head;
        }
        ListNode newHead = list.get(list.size() - k);
        list.get(list.size() - 1).next = head;
        list.get(list.size() - k - 1).next = null;
        return newHead;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1);
        ListNode head = new ListNode(list.get(0));
        ListNode newHead = head;
        for (int i = 1; i < list.size(); i++) {
            newHead.next = new ListNode(list.get(i));
            newHead = newHead.next;
        }
        rotateRight(head, 2);
    }
}
