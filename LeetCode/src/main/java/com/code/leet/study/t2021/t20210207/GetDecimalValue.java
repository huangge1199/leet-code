package com.code.leet.study.t2021.t20210207;

import com.code.leet.entiy.ListNode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 */
public class GetDecimalValue {
    /**
     * 1290. 二进制链表转整数
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num <<= 1;
            num |= head.val;
            head = head.next;
        }
        return num;
    }
}
