package com.code.lint.y2020.m01.d26;

import entiy.ListNode;

/**
 * @Author: hyy
 * @Date: 2020-01-26 02:33
 */

public class DeleteNode {
    /**
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        // Write your code here
        int num=0;
        ListNode temp = head;
        while (head!=null){
            num++;
            if(num>n){
                while (num<=m+1){
                    if(head.next!=null){
                        head = head.next;
                        temp = head;
                    }else{
                        temp = null;
                    }
                    num++;
                }
            }
            if(num==n){
                while (num<=m){
                    num++;
                    if(head.next!=null){
                        head.next = head.next.next;
                    } else {
                        break;
                    }
                }
            }
            head=head.next;
        }
        return temp;
    }
}
