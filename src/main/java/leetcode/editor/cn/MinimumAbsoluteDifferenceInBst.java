//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 
// 👍 264 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

//530:二叉搜索树的最小绝对差
class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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

        List<Integer> list = new ArrayList<>();

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(Math.abs(list.get(i)- list.get(i-1)),min);
            }
            return min;
        }

        private void dfs(TreeNode node){
            if(node==null){
                return;
            }
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}