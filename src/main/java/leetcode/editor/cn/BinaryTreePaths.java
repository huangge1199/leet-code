//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 540 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

//257:二叉树的所有路径
public class BinaryTreePaths {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<String>();
            dfs(root, "", paths);
            return paths;
        }

        public void dfs(TreeNode root, String path, List<String> paths) {
            if (root != null) {
                path += root.val;
                if (root.left == null && root.right == null) {
                    paths.add(path);
                } else {
                    path += "->";
                    dfs(root.left, path, paths);
                    dfs(root.right, path, paths);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}