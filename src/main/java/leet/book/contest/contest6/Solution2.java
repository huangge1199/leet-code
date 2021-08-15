package leet.book.contest.contest6;

import com.code.leet.entiy.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }

    public TreeNode swapTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode treeNode = root.left;
        root.left = swapTree(root.right);
        root.right = swapTree(treeNode);
        return root;
    }
}
