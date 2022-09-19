//给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。 
//
// 
// 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。 
// 
//
// 反转后，返回树的根节点。 
//
// 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。 
//
// 节点的 层数 等于该节点到根节点之间的边数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,3,5,8,13,21,34]
//输出：[2,5,3,8,13,21,34]
//解释：
//这棵树只有一个奇数层。
//在第 1 层的节点分别是 3、5 ，反转后为 5、3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [7,13,11]
//输出：[7,11,13]
//解释： 
//在第 1 层的节点分别是 13、11 ，反转后为 11、13 。 
// 
//
// 示例 3： 
//
// 
//输入：root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
//输出：[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
//解释：奇数层由非零值组成。
//在第 1 层的节点分别是 1、2 ，反转后为 2、1 。
//在第 3 层的节点分别是 1、1、1、1、2、2、2、2 ，反转后为 2、2、2、2、1、1、1、1 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数目在范围 [1, 2¹⁴] 内 
// 0 <= Node.val <= 10⁵ 
// root 是一棵 完美 二叉树 
// 
//
// 👍 7 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.*;

//2415:反转二叉树的奇数层
public class ReverseOddLevelsOfBinaryTree {
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new ReverseOddLevelsOfBinaryTree().new Solution();
        //TreeNode root = new TreeNode(Arrays.asList(2, 3, 5, 8, 13, 21, 34));
        TreeNode root = new TreeNode(Arrays.asList(7,13,11));
        solution.reverseOddLevels(root);
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
        public TreeNode reverseOddLevels(TreeNode root) {
            /*
            如果是空节点直接返回
             */
            if (root == null) {
                return null;
            }
            // 队列存入每层的节点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                /*
                拿出每层的节点放入列表中，并将下一层的节点放入队列中
                 */
                int size = queue.size();
                List<TreeNode> nodeList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    nodeList.add(node);
                    if (node.left != null) {
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                /*
                奇数层，在列表中交换收尾节点的值
                 */
                if (level == 1) {
                    int nodeSize = nodeList.size();
                    for (int i = 0; i < nodeSize / 2; i++) {
                        int num = nodeList.get(i).val;
                        nodeList.get(i).val = nodeList.get(nodeSize - i - 1).val;
                        nodeList.get(nodeSize - i - 1).val = num;
                    }
                }
                // 改变奇偶层
                level = 1 - level;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}