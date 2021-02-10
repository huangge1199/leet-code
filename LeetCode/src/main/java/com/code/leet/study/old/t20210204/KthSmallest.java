package com.code.leet.study.old.t20210204;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = getList(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    private List<Integer> getList(TreeNode root, List<Integer> list) {
        if(root==null){
            return list;
        }
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);

        return list;
    }
}
