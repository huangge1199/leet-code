package com.code.leet.entiy;

public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node prev;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node prev, Node head, Node next) {
        head.val = val;
        head.prev = prev;
        head.next = next;
    }
}
