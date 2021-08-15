package leet.book.contest.contest4;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
    }

    public int[][] solve(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            list.add(temp);
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            arr[i] = new int[temp.size()];
            for (int j = 0; j < temp.size(); j++) {
                arr[i][j] = temp.get(j);
            }
        }
        return arr;
    }
}
