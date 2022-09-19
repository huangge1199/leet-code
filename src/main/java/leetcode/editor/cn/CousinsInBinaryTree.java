//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 172 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//993:二叉树的堂兄弟节点
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CousinsInBinaryTree().new Solution();
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
        public boolean isCousins(TreeNode root, int x, int y) {
            int[][] paraent = getParent(root, x, y, new int[2][2], 1, -1);
            return paraent[0][0] != paraent[1][0] && paraent[0][1] == paraent[1][1];
        }

        private int[][] getParent(TreeNode root, int x, int y, int[][] paraent, int deep, int before) {
            if (paraent[1][1] > 0) {
                return paraent;
            }
            if (root.val == x || root.val == y) {
                x = root.val == x ? 0 : x;
                y = root.val == y ? 0 : y;
                if (paraent[0][1] > 0) {
                    paraent[1][0] = before;
                    paraent[1][1] = deep;
                } else {
                    paraent[0][0] = before;
                    paraent[0][1] = deep;
                }
            }
            if (root.left != null) {
                paraent = getParent(root.left, x, y, paraent, deep + 1, root.val);
            }
            if (paraent[1][1] > 0) {
                return paraent;
            }
            if (root.right != null) {
                paraent = getParent(root.right, x, y, paraent, deep + 1, root.val);
            }
            return paraent;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}