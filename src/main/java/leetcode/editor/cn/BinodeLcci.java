//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 👍 99 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.List;

//面试题 17.12:BiNode
public class BinodeLcci {
    public static void main(String[] args) {
        Solution solution = new BinodeLcci().new Solution();
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n1.left = n0;
        n2.right = n3;
        n5.right = n6;
        System.out.println(solution.convertBiNode(n4));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        TreeNode header = new TreeNode(-1);
        TreeNode temp = header;

        public TreeNode convertBiNode(TreeNode root) {
            dfs(root);
            return header.right;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                dfs(root.left);
            }
            root.left = null;
            temp.right = root;
            temp = temp.right;
            if (root.right != null) {
                dfs(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}