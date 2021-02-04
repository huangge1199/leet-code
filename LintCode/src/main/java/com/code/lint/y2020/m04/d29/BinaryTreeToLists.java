package com.code.lint.y2020.m04.d29;

import entiy.ListNode;
import entiy.TreeNode;
import util.CreateTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-04-29 11:09
 */

public class BinaryTreeToLists {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size()!=0){
            ListNode head = new ListNode(treeNodes.get(0).val);
            ListNode p = head;
            for (int i=1;i<treeNodes.size();i++){
                TreeNode treeNode = treeNodes.get(i);
                p.next = new ListNode(treeNode.val);
                p = p.next;
            }
            p.next = null;
            lists.add(head);
            treeNodes = level(treeNodes);
        }
        return lists;
    }

    public static List<TreeNode> level(List<TreeNode> treeNodes){
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

    public static void main(String[] args) {
        TreeNode treeNode = CreateTree.createTree("1,2,3,4");
        binaryTreeToLists(treeNode);
    }
}
