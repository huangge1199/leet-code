package leet.book.queueStack;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 13:43
 * @Description: No Description
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        private HashMap<Node, Node> use = new HashMap <> ();
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            if (use.containsKey(node)) {
                return use.get(node);
            }

            Node cloneNode = new Node(node.val, new ArrayList());
            use.put(node, cloneNode);

            for (Node neighbor: node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }
}
