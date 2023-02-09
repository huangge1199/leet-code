//<p>二叉树的 <strong>边界</strong> 是由 <strong>根节点 </strong>、<strong>左边界</strong> 、按从左到右顺序的<strong> 叶节点</strong> 和 <strong>逆序的右边界</strong> ，按顺序依次连接组成。</p>
//
//<p><strong>左边界 </strong>是满足下述定义的节点集合：</p>
//
//<ul> 
// <li>根节点的左子节点在左边界中。如果根节点不含左子节点，那么左边界就为 <strong>空</strong> 。</li> 
// <li>如果一个节点在左边界中，并且该节点有左子节点，那么它的左子节点也在左边界中。</li> 
// <li>如果一个节点在左边界中，并且该节点 <strong>不含</strong> 左子节点，那么它的右子节点就在左边界中。</li> 
// <li>最左侧的叶节点 <strong>不在</strong> 左边界中。</li> 
//</ul>
//
//<p><strong>右边界</strong> 定义方式与 <strong>左边界</strong> 相同，只是将左替换成右。即，右边界是根节点右子树的右侧部分；叶节点 <strong>不是</strong> 右边界的组成部分；如果根节点不含右子节点，那么右边界为 <strong>空</strong> 。</p>
//
//<p><strong>叶节点</strong> 是没有任何子节点的节点。对于此问题，根节点 <strong>不是</strong> 叶节点。</p>
//
//<p>给你一棵二叉树的根节点 <code>root</code> ，按顺序返回组成二叉树 <strong>边界</strong> 的这些值。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/11/boundary1.jpg" style="width: 299px; height: 290px;" /> 
//<pre>
//<strong>输入：</strong>root = [1,null,2,3,4]
//<strong>输出：</strong>[1,3,4,2]
//<b>解释：</b>
//- 左边界为空，因为二叉树不含左子节点。
//- 右边界是 [2] 。从根节点的右子节点开始的路径为 2 -&gt; 4 ，但 4 是叶节点，所以右边界只有 2 。
//- 叶节点从左到右是 [3,4] 。
//按题目要求依序连接得到结果 [1] + [] + [3,4] + [2] = [1,3,4,2] 。</pre>
//
//<p><strong>示例 2：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/11/boundary2.jpg" style="width: 599px; height: 411px;" /> 
//<pre>
//<strong>输入：</strong>root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
//<strong>输出：</strong>[1,2,4,7,8,9,10,6,3]
//<b>解释：</b>
//- 左边界为 [2] 。从根节点的左子节点开始的路径为 2 -&gt; 4 ，但 4 是叶节点，所以左边界只有 2 。
//- 右边界是 [3,6] ，逆序为 [6,3] 。从根节点的右子节点开始的路径为 3 -&gt; 6 -&gt; 10 ，但 10 是叶节点。
//- 叶节点从左到右是 [4,7,8,9,10]
//按题目要求依序连接得到结果 [1] + [2] + [4,7,8,9,10] + [6,3] = [1,2,4,7,8,9,10,6,3] 。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>树中节点的数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li> 
// <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 100</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 545:二叉树的边界
public class BoundaryOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BoundaryOfBinaryTree().new Solution();
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
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            if (root.left == null && root.right == null) {
                return list;
            }
            if (root.left != null) {
                list.addAll(getLeft(root.left));
            }

            list.addAll(getLeaf(root));

            if (root.right != null) {
                List<Integer> rightList = getRight(root.right);
                for (int i = rightList.size() - 1; i >= 0; i--) {
                    list.add(rightList.get(i));
                }
            }
            return list;
        }

        private List<Integer> getLeft(TreeNode node) {
            List<Integer> list = new ArrayList<>();
            if (node.left == null && node.right == null) {
                return new ArrayList<>();
            }
            list.add(node.val);
            if (node.left != null) {
                list.addAll(getLeft(node.left));
            } else {
                list.addAll(getLeft(node.right));
            }
            return list;
        }

        private List<Integer> getRight(TreeNode node) {
            List<Integer> list = new ArrayList<>();
            if (node.left == null && node.right == null) {
                return new ArrayList<>();
            }
            list.add(node.val);
            if (node.right != null) {
                list.addAll(getRight(node.right));
            } else {
                list.addAll(getRight(node.left));
            }
            return list;
        }

        private List<Integer> getLeaf(TreeNode node) {
            List<Integer> list = new ArrayList<>();
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            if (node.left != null) {
                list.addAll(getLeaf(node.left));
            }
            if (node.right != null) {
                list.addAll(getLeaf(node.right));
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
