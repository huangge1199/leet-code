package com.code.leet.study.t20210205;

import com.code.leet.entiy.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
