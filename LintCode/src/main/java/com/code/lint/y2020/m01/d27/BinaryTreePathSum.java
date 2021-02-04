package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;
import util.CreateTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 00:32
 */

public class BinaryTreePathSum {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static int sum = 0;

    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        if(root==null){
            return new ArrayList<>();
        }
        path.add(root.val);
        sum += root.val;
        if(root.left==null&&root.right==null){
            if(sum==target){
                result.add(new ArrayList(path));
            }
        }
        if(root.left!=null){
            binaryTreePathSum(root.left,target);
        }
        if(root.right!=null){
            binaryTreePathSum(root.right,target);
        }
        sum -= root.val;
        path.remove(path.size()-1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = CreateTree.createTree("1,1,1,3,4,4,3,#,#,1,#,5,7");
        binaryTreePathSum(root,6);
    }
}
