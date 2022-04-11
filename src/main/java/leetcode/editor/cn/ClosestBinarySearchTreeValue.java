//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 112 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//270:最接近的二叉搜索树值
public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValue().new Solution();
        // TO TEST
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
        public int closestValue(TreeNode root, double target) {
            double left = target;
            double right = target;
            float diff = 1e-6f;
            while (root != null) {
                if (Math.abs(root.val - target) < diff) {
                    return root.val;
                }
                if (root.val > target) {
                    right = root.val;
                    root = root.left;
                } else {
                    left = root.val;
                    root = root.right;
                }
            }

            if (Math.abs(left - target) < diff) {
                return (int) right;
            } else if (Math.abs(right - target) < diff) {
                return (int) left;
            } else {
                return target - left > right - target ? (int) right : (int) left;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
