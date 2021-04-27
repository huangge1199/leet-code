//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
// 
//
// 示例 2： 
//
// 
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 2 * 104] 内 
// 1 <= Node.val <= 105 
// 1 <= low <= high <= 105 
// 所有 Node.val 互不相同 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 178 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.Arrays;

//938:二叉搜索树的范围和
public class RangeSumOfBst {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RangeSumOfBst().new Solution();
        TreeNode treeNode;
        //32
        treeNode = new TreeNode(Arrays.asList(10, 5, 15, 3, 7, null, 18));
        System.out.println(solution.rangeSumBST(treeNode, 7, 15));
        //23
        treeNode = new TreeNode(Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6));
        System.out.println(solution.rangeSumBST(treeNode, 6, 10));
        //44
        treeNode = new TreeNode(Arrays.asList(15, 9, 21, 7, 13, 19, 23, 5, null, 11, null, 17));
        System.out.println(solution.rangeSumBST(treeNode, 21, 23));
        //63
        treeNode = new TreeNode(Arrays.asList(18, 9, 27, 6, 15, 24, 30, 3, null, 12, null, 21));
        System.out.println(solution.rangeSumBST(treeNode, 18, 24));
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

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}