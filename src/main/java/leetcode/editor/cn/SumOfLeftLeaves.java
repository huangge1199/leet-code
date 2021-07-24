//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 328 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//404:左叶子之和
class SumOfLeftLeaves {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SumOfLeftLeaves().new Solution();
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

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                }
                sum += sumOfLeftLeaves(root.left);
            }
            if (root.right != null) {
                sum += sumOfLeftLeaves(root.right);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}