package com.code.leet.study.t2021.t20210207;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 */
public class IsPalindrome {
    /**
     * 234. 回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        boolean bl = true;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int headIndex = 0;
        int size = list.size();
        while (headIndex < size - headIndex - 1) {
            if (!list.get(headIndex).equals(list.get(size - headIndex - 1))) {
                bl = false;
                break;
            }
            headIndex++;
        }
        return bl;
    }
}
