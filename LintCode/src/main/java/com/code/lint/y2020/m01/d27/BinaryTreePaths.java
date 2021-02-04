package com.code.lint.y2020.m01.d27;

import entiy.TreeNode;
import util.CreateTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 17:05
 */

public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
//    public static List<String> binaryTreePaths(TreeNode root) {
//        // write your code here
//        if(root==null){
//            return new ArrayList<>();
//        }
//        List<String> strings = new ArrayList<>();
//        List<TreeNode> treeNodes = new ArrayList<>();
//        List<Integer> trees = new ArrayList<>();
//        while(root!=null||treeNodes.size()>0){
//            while(root!=null){
//                trees.add(root.val);
//                treeNodes.add(root);
//                if(root.left==null&&root.right==null){
//                    if(trees.size()==0){
//                        continue;
//                    }
//                    String str = "";
//                    for(Integer num:trees){
//                        str += num + "->";
//                    }
//                    strings.add(str.substring(0,str.length()-2));
//                }
//                root = root.left;
//            }
//            if(treeNodes.size()>0){
//                root = treeNodes.get(treeNodes.size()-1).right;
//                treeNodes.remove(treeNodes.size()-1);
////                trees.remove(trees.size()-1);
//            }
//        }
//        return strings;
//    }
    static List<String> path = new ArrayList<>();
    static List<Integer> nums = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        nums.add(root.val);
        if(root.left==null&&root.right==null){
            String str = "";
            for (Integer num:nums){
                str += num + "->";
            }
            str = str.substring(0,str.length()-2);
            path.add(str);
        }
        if(root.left!=null){
            binaryTreePaths(root.left);
        }
        if(root.right!=null){
            binaryTreePaths(root.right);
        }
        nums.remove(nums.size()-1);
        return path;
    }
    public static void main(String[] args) {
        TreeNode root = CreateTree.createTree("1,2,3,#,5");
        binaryTreePaths(root);
    }
}
