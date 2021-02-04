package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-26 01:36
 */

public class MiddleNode {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        int num=0;
        int index;
        if(head==null){
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode next = head.next;
        while (head!=null){
            num++;
            listNodes.add(head);
            head = head.next;
        }
        if(num%2==0){
            index = num/2-1;
        }else {
            index = num/2;
        }
        return listNodes.get(index);
    }
}
