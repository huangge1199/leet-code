package com.code.leet.study.t2021.t20210205;

import com.code.leet.entiy.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
public class KthToLast {
    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode p;
        int count = 1;
        p = head;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }
        return p.val;
    }
}
