package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-26 02:25
 */

public class ReverseStore {
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list;
    }
}
