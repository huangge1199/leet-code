package com.code.leet.study.LinkNode.t20210210;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    /**
     * 143. 重排链表
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head.next;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        temp = head;
        int size = list.size();
        int count = (size + 1) / 2;
        for (int i = 1; i <= count; i++) {
            if (size - i != i - 1) {
                temp.next = list.get(size - i);
                temp.next.next = list.get(i - 1);
                temp = temp.next.next;
            } else {
                temp.next = list.get(i - 1);
                temp = temp.next;
            }
        }
        temp.next = null;
    }


}
