//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 198 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//671:二叉树中第二小的节点
class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
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
        int min = -1;
        int val;

        public int findSecondMinimumValue(TreeNode root) {
            val = root.val;
            dfs(root);
            return min;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            if (min != -1 && node.val >= min) {
                return;
            }
            if (node.val > val) {
                min = node.val;
            }

            dfs(node.left);
            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}