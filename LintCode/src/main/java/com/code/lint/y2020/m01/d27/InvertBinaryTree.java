package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 17:37
 */

public class InvertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        List<TreeNode> treeNodes = new ArrayList<>();
        if(root==null){
            return;
        }
        while (root!=null||treeNodes.size()>0){
            while(root!=null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                treeNodes.add(root);
                root = root.left;
            }
            if(treeNodes.size()>0){
                root = treeNodes.get(treeNodes.size()-1).right;
                treeNodes.remove(treeNodes.size()-1);
            }
        }
    }
}
