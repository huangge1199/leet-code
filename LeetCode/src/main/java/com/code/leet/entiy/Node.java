package com.code.leet.entiy;

import java.util.ArrayList;
import java.util.List;

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

    public Node(int val, Node random) {
        this.val = val;
        this.next = null;
        this.random = random;
    }

    public Node setHead(List<Integer> list, List<Integer> index) {
        Node head = new Node(list.get(0));
        int i = 1;
        int size = list.size();
        Node temp = head;
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(head);
        while (i < size) {
            temp.next = new Node(list.get(i));
            nodeList.add(temp.next);
            i++;
            temp = temp.next;
        }
        i = 0;
        temp = head;
        while (i < size) {
            if (index.get(i) != null) {
                temp.random = nodeList.get(index.get(i));
            }
            i++;
            temp = temp.next;
        }
        return head;
    }
}
