package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;
import util.CreateTree;

import java.util.ArrayList;
import java.util.List;

/**
 * error
 * @Author: hyy
 * @Date: 2020-01-27 15:48
 */

public class PreorderTraversal {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        // write your code here
//        List<TreeNode> treeNodes = new ArrayList<>();
//        List<Integer> trees = new ArrayList<>();
//        if(root==null){
//            return new ArrayList<>();
//        }
//        while (root!=null||treeNodes.size()>0){
//            while(root!=null){
//                trees.add(root.val);
//                treeNodes.add(root);
//                root = root.left;
//            }
//            if(treeNodes.size()>0){
//                root = treeNodes.get(treeNodes.size()-1).right;
//                treeNodes.remove(treeNodes.size()-1);
//            }
//        }
//        return trees;
//    }
    static List<Integer> tree = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if(root==null){
            return new ArrayList<>();
        }
        tree.add(root.val);
        if(root.left!=null){
            preorderTraversal(root.left);
        }
        if(root.right!=null){
            preorderTraversal(root.right);
        }
        return tree;
    }

    public static void main(String[] args) {
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
        TreeNode root = CreateTree.createTree("1,#,2,3");
        preorderTraversal(root);
    }
}
