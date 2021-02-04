package com.code.lint.y2020.m05.d29;

import entiy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: hyy
 * @Date: 2020-05-29 10:41
 */

public class LevelOrder {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> all = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        int num = 1;
        while (!queue.isEmpty()) {
            List<Integer> treeNum = new ArrayList<>();
            int tempNum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode temp = queue.poll();
                treeNum.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                    tempNum++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    tempNum++;
                }
            }
            num = tempNum;
            all.add(treeNum);
        }
        return all;
    }
}
