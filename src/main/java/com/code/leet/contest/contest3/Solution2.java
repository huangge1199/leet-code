package com.code.leet.contest.contest3;

import com.code.leet.entiy.TreeNode;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }

    public int countInconsistentNode(TreeNode root1, TreeNode root2) {
        int count = 0;
        if (root1 == null && root2 != null) {
            count += 1 + countInconsistentNode(null, root2.left);
            count += countInconsistentNode(null, root2.right);
        } else if (root1 != null && root2 == null) {
            count += 1 + countInconsistentNode(null, root1.left);
            count += countInconsistentNode(null, root1.right);
        } else if (root1 != null && root2 != null) {
            count += root1.val == root2.val ? 0 : 2;
            count += countInconsistentNode(root1.left, root2.left);
            count += countInconsistentNode(root1.right, root2.right);
        }
        return count;
    }
}
