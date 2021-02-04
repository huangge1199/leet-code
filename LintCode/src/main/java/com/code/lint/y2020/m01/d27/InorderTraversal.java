package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 17:43
 */

public class InorderTraversal {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */

    List<Integer> trees = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if(root==null){
            return trees;
        }
        inorderTraversal(root.left);
        trees.add(root.val);
        inorderTraversal(root.right);
        return trees;
    }
}
