package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;

/**
 * @Author: hyy
 * @Date: 2020-01-27 19:22
 */

public class GetAns {
    /**
     * @param root: the root of the binary tree
     * @return: the number of nodes
     */
    int num = 0;
    public int getAns(TreeNode root) {
        // Write your code here
        if(root==null){
            return 0;
        }
        num++;
        if(root.left!=null){
            getAns(root.left);
        }
        if(root.right!=null){
            getAns(root.right);
        }
        return num;
    }
}
