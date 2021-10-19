package contest.y2021.fall.term.contest1;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/9/25-15:15
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {
        dfs(root);
        return set.size();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
