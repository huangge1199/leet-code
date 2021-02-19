package com.code.leet.study.t2021.t20210209;

import com.code.leet.entiy.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    /**
     * 2. 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode temp = l1;
        while (temp != null) {
            sum = l2 == null ? temp.val + sum : temp.val + l2.val + sum;
            temp.val = sum % 10;
            sum = sum / 10;

            if (l2 != null && temp.next == null && l2.next == null && sum > 0) {
                temp.next = new ListNode(sum);
                sum = 0;
                l2 = null;
            } else if (l2 != null && temp.next == null && l2.next != null) {
                temp.next = l2.next;
                l2 = null;
            } else if (l2 != null) {
                l2 = l2.next;
            } else {
                if (temp.next == null && sum > 0) {
                    temp.next = new ListNode(sum);
                    sum = 0;
                }
                l2 = null;
            }
            temp = temp.next;
        }
        return l1;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int sum = 0;
//        ListNode temp = l1;
//        while (temp != null && l2 != null) {
//            sum = temp.val + l2.val + sum;
//            temp.val = sum % 10;
//            sum = sum / 10;
//            if (temp.next == null) {
//                if (l2.next == null && sum > 0) {
//                    temp.next = new ListNode(sum);
//                    sum = 0;
//                } else {
//                    temp.next = l2.next;
//                }
//                l2 = null;
//            } else {
//                l2 = l2.next;
//            }
//            temp = temp.next;
//        }
//        while (temp != null) {
//            sum = temp.val + sum;
//            temp.val = sum % 10;
//            sum = sum / 10;
//            if (temp.next == null && sum > 0) {
//                temp.next = new ListNode(sum);
//                sum = 0;
//            }
//            temp = temp.next;
//        }
//        return l1;
//    }
}
