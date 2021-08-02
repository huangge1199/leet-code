//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 945 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102:二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}