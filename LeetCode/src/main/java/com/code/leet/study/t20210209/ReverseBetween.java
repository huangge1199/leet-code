package com.code.leet.study.t20210209;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseBetween {
    /**
     * 92. 反转链表 II
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == 1) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        int num = 1;
        ListNode before = new ListNode(0);
        ListNode after = null;
        ListNode temp = head;
        while (temp != null) {
            if (num == m - 1) {
                before = temp;
            }
            if (num >= m && num <= n) {
                list.add(temp);
            }
            if (num == n) {
                after = temp.next;
                break;
            }
            temp = temp.next;
            num++;
        }
        ListNode newHead = before;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            before.next = list.get(i);
            before = before.next;
        }
        before.next = after;
        if (m == 1) {
            head = newHead.next;
        }
        return head;
    }
}
