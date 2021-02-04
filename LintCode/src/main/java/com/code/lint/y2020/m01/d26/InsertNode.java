package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

/**
 *
 * 219. 在排序链表中插入一个节点
 * 中文
 * English
 *
 * 在链表中插入一个节点。
 * 样例
 *
 * 样例 1：
 *
 * 输入：head = 1->4->6->8->null, val = 5
 * 输出：1->4->5->6->8->null
 *
 * 样例 2：
 *
 * 输入：head = 1->null, val = 2
 * 输出：1->2->null
 *
 * @Author: hyy
 * @Date: 2020-01-26 01:58
 */

public class InsertNode {
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        if(head==null){
            ListNode newNode = new ListNode(val);
            newNode.next = null;
            return newNode;
        }
        if(val<=head.val){
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }
        ListNode temp = head;
        while(val>head.val){
            if(head.next!=null&&val>head.next.val){
                head = head.next;
            }else{
                ListNode newNode = new ListNode(val);
                newNode.next = head.next;
                head.next = newNode;
                break;
            }
        }
        return temp;
    }
}
