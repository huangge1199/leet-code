package com.code.leet.study.LinkNode.t20210208;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    /**
     * 19. 删除链表的倒数第 N 个结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if (n == list.size() && head != null) {
            head = head.next;
        } else if (list.size() != 1) {
            list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
        }
        return head;
    }
}
