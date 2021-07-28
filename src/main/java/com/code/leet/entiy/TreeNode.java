package com.code.leet.entiy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: hyy
 * @Date: 2020-02-13 18:25
 */
public class TreeNode {
    public TreeNode left;
    public Integer val;
    public TreeNode right;

    public TreeNode() {
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
        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            if (treeNodeList.size() == 0) {
                this.val = list.get(i);
                treeNodeList.add(this);
                index = 0;
                size = 1;
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
                    } else {
                        treeNodeList.add(index, null);
                    }
                    index++;
                }
                if (treeNodeList.size() == size * 2) {
                    index = 0;
                    size = treeNodeList.size();
                }
            }
        }
    }

    public TreeNode preTreeNode(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < list.size(); i = i + 2) {
            TreeNode node = queue.poll();
            Integer left = list.get(i);
            if (node == null) {
                queue.add(null);
                queue.add(null);
            } else {
                if (left != null) {
                    node.left = new TreeNode(left);
                }
                queue.add(node.left);
                Integer right = i + 1 < list.size() ? list.get(i + 1) : null;
                if (right != null) {
                    node.right = new TreeNode(right);
                }
                queue.add(node.right);
            }
        }
        return root;
    }

    public TreeNode search(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        TreeNode temp = search(root.left, target);
        if (temp != null) {
            return temp;
        }
        return search(root.right, target);
    }
}
