//<p>给你一棵二叉树的根节点 <code>root</code> ，找出并返回满足要求的节点数，要求节点的值等于其 <strong>子树</strong> 中值的 <strong>平均值</strong> 。</p>
//
//<p><strong>注意：</strong></p>
//
//<ul>
//	<li><code>n</code> 个元素的平均值可以由 <code>n</code> 个元素 <strong>求和</strong> 然后再除以 <code>n</code> ，并 <strong>向下舍入</strong> 到最近的整数。</li>
//	<li><code>root</code> 的 <strong>子树</strong> 由 <code>root</code> 和它的所有后代组成。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img src="https://assets.leetcode.com/uploads/2022/03/15/image-20220315203925-1.png" style="width: 300px; height: 212px;">
//<pre><strong>输入：</strong>root = [4,8,5,0,1,null,6]
//<strong>输出：</strong>5
//<strong>解释：</strong>
//对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
//对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
//对值为 0 的节点：子树的平均值 0 / 1 = 0 。
//对值为 1 的节点：子树的平均值 1 / 1 = 1 。
//对值为 6 的节点：子树的平均值 6 / 1 = 6 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img src="https://assets.leetcode.com/uploads/2022/03/26/image-20220326133920-1.png" style="width: 80px; height: 76px;">
//<pre><strong>输入：</strong>root = [1]
//<strong>输出：</strong>1
//<strong>解释：</strong>对值为 1 的节点：子树的平均值 1 / 1 = 1。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点数目在范围 <code>[1, 1000]</code> 内</li>
//	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
//</ul>
//<div><li>👍 8</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 2265:统计值等于子树平均值的节点数
public class CountNodesEqualToAverageOfSubtree {
    public static void main(String[] args) {
        Solution solution = new CountNodesEqualToAverageOfSubtree().new Solution();
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
        public int averageOfSubtree(TreeNode root) {
            counts(root);
            sums(root);
            return count;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        private int counts(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int cnt = counts(root.left) + counts(root.right) + 1;
            queue.add(cnt);
            return cnt;
        }

        private int sums(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = root.val;
            sum += sums(root.left);
            sum += sums(root.right);
            if (sum / queue.poll() == root.val) {
                count++;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
