package com.code.leet.entiy;

import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-02-12 14:36
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(List<Integer> list){
        if(list.size()==0){
            return;
        }
        if(list.size()==1){
            this.val = list.get(0);
            return;
        }
        if(list.size()==2){
            this.val = list.get(0);
            this.next = new ListNode(list.get(1));
            return;
        }
        this.val = list.get(0);
        this.next = new ListNode(list.get(1));
        ListNode newHead = this.next;
        for (int i = 2; i < list.size(); i++) {
            newHead.next = new ListNode(list.get(i));
            newHead = newHead.next;
        }
    }
}
