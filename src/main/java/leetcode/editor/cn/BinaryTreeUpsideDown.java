//给你一个二叉树的根节点 root ，请你将此二叉树上下翻转，并返回新的根节点。 
//
// 你可以按下面的步骤翻转一棵二叉树： 
//
// 
// 原来的左子节点变成新的根节点 
// 原来的根节点变成新的右子节点 
// 原来的右子节点变成新的左子节点 
// 
//
// 上面的步骤逐层进行。题目数据保证每个右节点都有一个同级节点（即共享同一父节点的左节点）且不存在子节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5]
//输出：[4,5,2,null,null,3,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 10] 内 
// 1 <= Node.val <= 10 
// 树中的每个右节点都有一个同级节点（即共享同一父节点的左节点） 
// 树中的每个右节点都没有子节点 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 102 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//156:上下翻转二叉树
public class BinaryTreeUpsideDown {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeUpsideDown().new Solution();
        // TO TEST
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        solution.upsideDownBinaryTree(n1);
    }
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
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            if (root == null || root.left == null) {
                return root;
            }
            dfs(root);
            root.left = null;
            root.right = null;
            return node;
        }

        TreeNode node;
        TreeNode temp;

        private void dfs(TreeNode root) {
            if (root == null || root.left == null) {
                node = root;
                temp = root;
                return;
            }
            dfs(root.left);
            temp.left = root.right;
            temp.right = root;
            temp = root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
