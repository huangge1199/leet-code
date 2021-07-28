//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 354 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.*;

//863:二叉树中所有距离为 K 的结点
public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
        TreeNode root = new TreeNode();
        root = root.preTreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));

        solution.distanceK(root, root.search(root, 5), 2);
    }
    //力扣代码
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
        private Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (k == 0) {
                return Arrays.asList(target.val);
            }
            if (!root.val.equals(target.val)) {
                serchTarget(root, target.val, true);
            }
            int index = 1;
            while (!stack.isEmpty() && k >= index) {
                TreeNode node = stack.pop();
                dfs(node, 0, k - index);
                index++;
            }
            return list;
        }

        private boolean serchTarget(TreeNode root, int val, boolean bl) {
            if (root == null) {
                return true;
            }
            if (root.val == val) {
                return false;
            }
            if (bl) {
                stack.push(root);
            }
            bl = serchTarget(root.left, val, bl) || serchTarget(root.right, val, bl);
            if (bl) {
                stack.pop();
            }
            return bl;
        }

        private void dfs(TreeNode root, int index, int k) {
            if (root == null) {
                return;
            }
            if (index == k) {
                list.add(root.val);
                return;
            }
            dfs(root.left, index + 1, k);
            dfs(root.right, index + 1, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}