//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 170 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//429:N 叉树的层序遍历
class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    list.add(node.val);
                    List<Node> nodeList = node.children;
                    for (Node temp : nodeList) {
                        queue.add(temp);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}