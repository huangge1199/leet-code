package com.code.leet.entiy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node prev;
    public Node child;
    public Node left;
    public Node right;
    public List<Node> children;

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

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    public Node(List<Integer> list) {
        this.val = list.get(0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        for (int i = 2; i < list.size(); i++) {
            Node root = queue.poll();
            root.children = new ArrayList<>();
            while (i < list.size() && list.get(i) != null) {
                Node node = new Node(list.get(i));
                root.children.add(node);
                queue.add(node);
                i++;
            }
        }
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
