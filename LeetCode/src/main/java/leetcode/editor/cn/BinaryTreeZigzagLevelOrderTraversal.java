//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 421 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//103:二叉树的锯齿形层序遍历
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            TreeNode temp;
            List<Integer> list;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    temp = stack1.pop();
                    list.add(temp.val);
                    if (temp.left != null) {
                        stack2.push(temp.left);
                    }
                    if (temp.right != null) {
                        stack2.push(temp.right);
                    }
                    result.add(list);
                }
                list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    temp = stack2.pop();
                    list.add(temp.val);
                    if (temp.right != null) {
                        stack1.push(temp.right);
                    }
                    if (temp.left != null) {
                        stack1.push(temp.left);
                    }
                    result.add(list);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}