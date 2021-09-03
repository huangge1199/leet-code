//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 303 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//652:寻找重复的子树
class FindDuplicateSubtrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
        Map<String, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap();
            ans = new ArrayList();
            collect(root);
            return ans;
        }

        public String collect(TreeNode node) {
            if (node == null) {
                return "#";
            }
            String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
            count.put(serial, count.getOrDefault(serial, 0) + 1);
            if (count.get(serial) == 2) {
                ans.add(node);
            }
            return serial;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}