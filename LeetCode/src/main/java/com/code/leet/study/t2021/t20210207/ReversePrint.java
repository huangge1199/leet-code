package com.code.leet.study.t2021.t20210207;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = list.get(size - 1 - i);
        }
        return arr;
    }
}
