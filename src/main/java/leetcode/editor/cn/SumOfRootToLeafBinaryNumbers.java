//<p>给出一棵二叉树，其上每个结点的值都是&nbsp;<code>0</code>&nbsp;或&nbsp;<code>1</code>&nbsp;。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。</p>
//
//<ul>
//	<li>例如，如果路径为&nbsp;<code>0 -&gt; 1 -&gt; 1 -&gt; 0 -&gt; 1</code>，那么它表示二进制数&nbsp;<code>01101</code>，也就是&nbsp;<code>13</code>&nbsp;。</li>
//</ul>
//
//<p>对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。</p>
//
//<p>返回这些数字之和。题目数据保证答案是一个 <strong>32 位 </strong>整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png" />
//<pre>
//<strong>输入：</strong>root = [1,0,1,0,1,0,1]
//<strong>输出：</strong>22
//<strong>解释：</strong>(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [0]
//<strong>输出：</strong>0
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中的节点数在&nbsp;<code>[1, 1000]</code>&nbsp;范围内</li>
//	<li><code>Node.val</code>&nbsp;仅为 <code>0</code> 或 <code>1</code>&nbsp;</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 159</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

// 1022:从根到叶的二进制数之和
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
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
        public int sumRootToLeaf(TreeNode root) {
            sum = 0;
            if (root != null) {
                dfs(root, 0);
            }
            return sum;
        }

        int sum;

        private void dfs(TreeNode root, int num) {
            num = num * 2 + root.val;
            if (root.left == null && root.right == null) {
                sum += num;
                return;
            }
            if (root.left != null) {
                dfs(root.left, num);
            }
            if (root.right != null) {
                dfs(root.right, num);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
