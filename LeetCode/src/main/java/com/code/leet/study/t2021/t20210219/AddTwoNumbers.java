package com.code.leet.study.t2021.t20210219;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {
    /**
     * 445. 两数相加 II
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null) {
            list1.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            list2.add(temp2);
            temp2 = temp2.next;
        }
        if (list1.size() > list2.size()) {
            return add(list1,list2);
        }else {
            return add(list2,list1);
        }
    }

    private ListNode add(List<ListNode> list1, List<ListNode> list2){
        int sum = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0;
        for (; i < size2; i++) {
            sum = list2.get(size2 - 1 - i).val + list1.get(size1 - 1 - i).val + sum;
            list1.get(size1 - 1 - i).val = sum % 10;
            sum = sum / 10;
        }
        while (sum > 0) {
            if(size1 - 1 - i>=0){
                sum = list1.get(size1 - 1 - i).val + sum;
                list1.get(size1 - 1 - i).val = sum % 10;
                sum = sum / 10;
                i++;
            }else{
                break;
            }
        }
        if(sum>0){
            ListNode head = new ListNode(sum);
            head.next = list1.get(0);
            return head;
        }
        return list1.get(0);
    }
}
