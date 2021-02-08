package com.code.leet.study.t20210208;

import com.code.leet.entiy.ListNode;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 */
public class IsPalindrome {
    ListNode temp;

    /**
     * 面试题 02.06. 回文链表
     */
    public boolean isPalindrome(ListNode head) {
        temp = head;
        return isP(head);
    }

    public boolean isP(ListNode curNode) {
        if (curNode != null) {
            if (isP(curNode.next)) {
                if (curNode.val != temp.val) {
                    return false;
                }
                temp = temp.next;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
