//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 1159 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//98:验证二叉搜索树
class ValidateBinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}