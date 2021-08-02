package com.code.leet.contest.contest1;

import com.code.leet.entiy.ListNode;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println();
    }

    public ListNode solve(ListNode head) {
        if (head == null) {
            return null;
        }
        int num1 = 1;
        int num2 = 2;
        ListNode result = new ListNode(head.val);
        int index = 3;
        ListNode temp = result;
        ListNode temp1 = head.next;
        temp.next = new ListNode(temp1.val);
        temp1 = temp1.next;
        temp = temp.next;
        while (temp1 != null) {
            if (index == num1 + num2) {
                temp.next = new ListNode(temp1.val);
                temp = temp.next;
                num1 = num2;
                num2 = index;
            }
            index++;
            temp1 = temp1.next;
        }
        return result;
    }
}
