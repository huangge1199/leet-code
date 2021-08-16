//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 539 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//572:另一棵树的子树
class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SubtreeOfAnotherTree().new Solution();
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

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }
            return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean check(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null || root.val != subRoot.val) {
                return false;
            }
            return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}