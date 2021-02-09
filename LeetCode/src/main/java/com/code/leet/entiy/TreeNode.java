package com.code.leet.entiy;


/**
 * @Author: hyy
 * @Date: 2020-02-13 18:25
 */
public class TreeNode {
    public TreeNode left;
    public Integer val;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
