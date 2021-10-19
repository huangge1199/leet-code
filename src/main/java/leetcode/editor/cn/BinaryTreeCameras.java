//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 
//提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 330 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

//968:监控二叉树
class BinaryTreeCameras {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreeCameras().new Solution();
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
        public int minCameraCover(TreeNode root) {
            int[] array = dfs(root);
            return array[1];
        }

        public int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{Integer.MAX_VALUE / 2, 0, 0};
            }
            int[] leftArray = dfs(root.left);
            int[] rightArray = dfs(root.right);
            int[] array = new int[3];
            array[0] = leftArray[2] + rightArray[2] + 1;
            array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
            array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
            return array;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}