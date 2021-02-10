package com.code.leet.study.LinkNode.t20210207;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    /**
     * 876. 链表的中间结点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }
}
