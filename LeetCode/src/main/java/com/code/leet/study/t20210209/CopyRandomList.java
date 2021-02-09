package com.code.leet.study.t20210209;

import com.code.leet.entiy.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class CopyRandomList {

    /**
     * 138. 复制带随机指针的链表
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return copy(head, map);
    }

    private Node copy(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copy(head.next, map);
        node.random = copy(head.random, map);
        return node;
    }
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        Node newHead = new Node(head.val);
//        Node temp = newHead;
//        List<Node> list = new ArrayList<>();
//        List<Node> newlist = new ArrayList<>();
//        list.add(head);
//        newlist.add(temp);
//        head = head.next;
//        while (head != null) {
//            list.add(head);
//            temp.next = new Node(head.val);
//            head = head.next;
//            temp = temp.next;
//            newlist.add(temp);
//        }
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            newlist.get(i).random = list.get(i).random == null ? null : newlist.get(list.indexOf(list.get(i).random));
//        }
//
//        return newHead;
//    }
}
