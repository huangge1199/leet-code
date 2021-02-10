package com.code.leet.study.LinkNode.t20210207;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {
    /**
     * 面试题 02.01. 移除重复节点
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        ListNode pro = null;
        while (temp != null) {
            if (list.contains(temp.val)) {
                pro.next = temp.next;
            } else {
                list.add(temp.val);
                pro = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
