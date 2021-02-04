package com.code.lint.y2020.m04.d29;

import entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-04-29 09:39
 */

public class LevelOrder {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size()!=0){
            List<Integer> list = new ArrayList<>();
            for (TreeNode treeNode:treeNodes) {
                list.add(treeNode.val);
            }
            lists.add(list);
            treeNodes = level(treeNodes);
        }
        return lists;
    }

    public List<TreeNode> level(List<TreeNode> treeNodes){
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (TreeNode treeNode:treeNodes) {
            if(treeNode.left!=null){
                treeNodeList.add(treeNode.left);
            }
            if(treeNode.right!=null){
                treeNodeList.add(treeNode.right);
            }
        }
        return treeNodeList;
    }
}
