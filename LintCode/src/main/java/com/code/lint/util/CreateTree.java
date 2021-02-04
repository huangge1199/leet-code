package com.code.lint.util;

import entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-01-27 16:08
 */

public class CreateTree {
    public static TreeNode createTree(String str){
        TreeNode root = null;
        List<TreeNode> treeNodes = new ArrayList<>();

        String[] val = str.split(",");
        root = new TreeNode(Integer.parseInt(val[0]));
        treeNodes.add(root);
        int j=0;
        for (int i=1;i<val.length;i++){
            TreeNode temp;
            if(val[i].equals("#")){
                temp = null;
            }else{
                temp = new TreeNode(Integer.parseInt(val[i]));
                treeNodes.add(temp);
            }
            if(i%2==0){
                treeNodes.get(j).right = temp;
                j++;
            }else{
                treeNodes.get(j).left = temp;
            }
        }

        return root;
    }
}
