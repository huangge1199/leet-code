package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;

/**
 * @Author: hyy
 * @Date: 2020-01-27 00:04
 */

public class MaxDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left >= right ? left + 1 : right + 1;
    }
}
