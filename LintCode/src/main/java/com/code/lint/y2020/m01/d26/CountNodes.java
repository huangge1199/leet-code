package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

/**
 *
 * 466. 链表节点计数
 *
 * 计算链表中有多少个节点.
 * 样例
 *
 * 样例  1:
 * 	输入:  1->3->5->null
 * 	输出: 3
 *
 * 	样例解释:
 * 	返回链表中结点个数，也就是链表的长度.
 *
 * 样例 2:
 * 	输入:  null
 * 	输出: 0
 *
 * 	样例解释:
 * 	空链表长度为0
 *
 * @Author: hyy
 * @Date: 2020-01-26 01:52
 */

public class CountNodes {
    /**
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {
        // write your code here
        int num=0;
        while (head!=null){
            num++;
            head = head.next;
        }
        return num;
    }
}
