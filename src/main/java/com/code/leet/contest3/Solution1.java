package com.code.leet.contest3;

import com.code.leet.entiy.TreeNode;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
    }

    public int countNodes(TreeNode root, int val) {
        int count = 0;
        if (root != null) {
            if (root.val == val) {
                count++;
            }
            count += countNodes(root.left, val);
            count += countNodes(root.right, val);
        }
        return count;
    }
}
