//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 127 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.*;

//783:二叉搜索树节点最小距离
public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
        public int minDiffInBST(TreeNode root) {
            int min = Integer.MAX_VALUE;
            TreeNode pre = null;
            Deque<TreeNode> stk = new LinkedList<>();
            while (root != null || !stk.isEmpty()) {
                while (root != null) {
                    stk.offerLast(root);
                    root = root.left;
                }
                root = stk.pollLast();
                if (pre != null) {
                    min = Math.min(min, root.val - pre.val);
                }
                pre = root;
                root = root.right;
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}