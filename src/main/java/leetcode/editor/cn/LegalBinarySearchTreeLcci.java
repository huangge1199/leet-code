//<p>实现一个函数，检查一棵二叉树是否为二叉搜索树。</p><strong>示例 1:</strong><pre><strong>输入:</strong><br>    2<br>   / &#92<br>  1   3<br><strong>输出:</strong> true<br></pre><strong>示例 2:</strong><pre><strong>输入:</strong><br>    5<br>   / &#92<br>  1   4<br>     / &#92<br>    3   6<br><strong>输出:</strong> false<br><strong>解释:</strong> 输入为: [5,1,4,null,null,3,6]。<br>     根节点的值为 5 ，但是其右子节点值为 4 。</pre><div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉搜索树</li><li>二叉树</li></div></div><br><div><li>👍 76</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

// 面试题 04.05:合法二叉搜索树
public class LegalBinarySearchTreeLcci {
    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
        // TO TEST
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
        public boolean isValidBST(TreeNode root) {
            return dfs(root, null, null);
        }

        public boolean dfs(TreeNode node, Integer lower, Integer upper) {
            if (node == null) {
                return true;
            }

            int val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }

            if (!dfs(node.right, val, upper)) {
                return false;
            }
            return dfs(node.left, lower, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
