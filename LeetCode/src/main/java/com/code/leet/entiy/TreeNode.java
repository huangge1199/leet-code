package com.code.leet.entiy;


import java.util.ArrayList;
import java.util.List;

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

    public TreeNode(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (treeNodeList.size() == 0) {
                this.val = list.get(i);
                treeNodeList.add(this);
                index = 0;
            } else {
                TreeNode root = treeNodeList.get(index);
                treeNodeList.remove(index);
                TreeNode left;
                if (list.get(i) != null && root != null) {
                    left = new TreeNode(list.get(i));
                    root.left = left;
                    treeNodeList.add(index, left);
                } else {
                    treeNodeList.add(index, null);
                }
                i++;
                index++;
                TreeNode right;
                if (i < list.size()) {
                    if (list.get(i) != null && root != null) {
                        right = new TreeNode(list.get(i));
                        root.right = right;
                        treeNodeList.add(index, right);
                    }else{
                        treeNodeList.add(index, null);
                    }
                    index++;
                }
                if (index == treeNodeList.size()*2) {
                    index = 0;
                }
            }
        }
    }
}
