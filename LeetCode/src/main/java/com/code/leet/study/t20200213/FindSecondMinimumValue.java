package com.code.leet.study.t20200213;

import entiy.TreeNode;

/**
 * @Author: hyy
 * @Date: 2020-02-13 18:24
 */

public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null){
            return -1;
        }
        int min;
        if (root.left.val < root.right.val) {
            if(root.val==root.left.val){
                min = root.right.val;
            }else{
                min = root.left.val;
            }
        } else if (root.left.val > root.right.val) {
            if(root.val==root.right.val){
                min = root.left.val;
            }else{
                min = root.right.val;
            }
        } else {
            if (root.left.val == root.val) {
                min = -1;
            } else {
                min = root.left.val;
            }
        }
        return min;
    }
}
