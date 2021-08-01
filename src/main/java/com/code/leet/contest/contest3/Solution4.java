package com.code.leet.contest.contest3;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
    }

    List<Integer> list = new ArrayList<>();

    public int splitTree(TreeNode root) {
        int total = dfs(root);
        list.remove(list.size() - 1);
        Collections.sort(list);
        int result = Integer.MAX_VALUE;
        for (Integer integer : list) {
            result = Math.min(result, Math.abs(total - 2 * integer));
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += dfs(root.left);
        sum += dfs(root.right);
        list.add(sum);
        return sum;
    }
}
