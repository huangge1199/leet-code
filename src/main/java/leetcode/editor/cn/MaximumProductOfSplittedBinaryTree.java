//<p>给你一棵二叉树，它的根为&nbsp;<code>root</code> 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。</p>
//
//<p>由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/02/sample_1_1699.png" style="height: 200px; width: 495px;"></strong></p>
//
//<pre><strong>输入：</strong>root = [1,2,3,4,5,6]
//<strong>输出：</strong>110
//<strong>解释：</strong>删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/02/sample_2_1699.png" style="height: 200px; width: 495px;"></p>
//
//<pre><strong>输入：</strong>root = [1,null,2,3,4,null,null,5,6]
//<strong>输出：</strong>90
//<strong>解释：</strong>移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>root = [2,3,9,10,7,8,6,5,4,11,1]
//<strong>输出：</strong>1025
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>root = [1,1]
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>每棵树最多有&nbsp;<code>50000</code>&nbsp;个节点，且至少有&nbsp;<code>2</code>&nbsp;个节点。</li>
//	<li>每个节点的值在&nbsp;<code>[1, 10000]</code>&nbsp;之间。</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 1339:分裂二叉树的最大乘积
public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfSplittedBinaryTree().new Solution();
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
        public int maxProduct(TreeNode root) {
            map = new HashMap<>();
            getSums(root);
            dfs(root, map.get(root));
            return (int) (max % 1000000007);
        }

        Map<TreeNode, Integer> map;
        long max = 0;

        private int getSums(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val;
            if (node.left != null) {
                sum += getSums(node.left);
            }
            if (node.right != null) {
                sum += getSums(node.right);
            }
            map.put(node, sum);
            return sum;
        }

        private void dfs(TreeNode node, int sum) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                int num1 = map.get(node.left);
                max = Math.max(max, (long) num1 * (sum - num1));
                dfs(node.left, sum);
            }
            if (node.right != null) {
                int num1 = map.get(node.right);
                max = Math.max(max, (long) num1 * (sum - num1));
                dfs(node.right, sum);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
