//从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。 
//
// 给定一个由不同节点组成的二叉搜索树 root，输出所有可能生成此树的数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [2,1,3]
//输出: [[2,1,3],[2,3,1]]
//解释: 数组 [2,1,3]、[2,3,1] 均可以通过从左向右遍历元素插入树中形成以下二叉搜索树
//       2 
//      / \ 
//     1   3
// 
//
// 
//
// 示例 2: 
//
// 
//输入: root = [4,1,null,null,3,2]
//输出: [[4,1,3,2]]
// 
//
// 
//
// 提示： 
//
// 
// 二叉搜索树中的节点数在 [0, 1000] 的范围内 
// 1 <= 节点值 <= 10^6 
// 
// 用例保证符合要求的数组数量不超过 5000 
// 
// 
// Related Topics 树 二叉搜索树 回溯 二叉树 👍 88 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TreeNode;

import java.util.*;

//面试题 04.09:二叉搜索树序列
public class BstSequencesLcci {
    public static void main(String[] args) {
        Solution solution = new BstSequencesLcci().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(Arrays.asList(2, 1, 3));
        solution.BSTSequences(root);
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
        private List<List<Integer>> result;

        public List<List<Integer>> BSTSequences(TreeNode root) {
            result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            if (root == null) {
                result.add(path);
                return result;
            }
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            bfs(queue, path);
            return result;
        }

        private void bfs(List<TreeNode> queue, List<Integer> path) {
            if (queue.isEmpty()) {
                result.add(new ArrayList<>(path));
                return;
            }
            List<TreeNode> copy = new ArrayList<>(queue);
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.get(i);
                path.add(cur.val);
                queue.remove(i);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                bfs(queue, path);
                path.remove(path.size() - 1);
                queue = new ArrayList<>(copy);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
