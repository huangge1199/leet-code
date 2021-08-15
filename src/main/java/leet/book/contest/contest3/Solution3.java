package leet.book.contest.contest3;

import com.code.leet.entiy.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.list1 = Arrays.asList(1, 1, 1, 2, 2);
        solution.solve(new int[][]{{0, 3}, {0, 2}, {1, 0}});
    }

    private List<Integer> list1 = new ArrayList<>();

    public int[] solve(int[][] operations) {
        int[] result = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            result[i] = list1.get(i);
        }
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 0) {
                for (int j = 0; j < list1.size(); j++) {
                    if (operations[i][1] >= list1.get(j)) {
                        list1.add(j, operations[i][1]);
                    }
                }
            } else {
                list1.remove(0);
            }
            result[i] = list1.get(0);
        }
        return result;
    }

    private List<Integer> list = new ArrayList<>();

    public int[] solve(TreeNode root, int[][] operations) {
        dfs(root);
        int[] result = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 0) {
                for (int j = 0; j < list.size(); j++) {
                    if (operations[i][1] >= list.get(j)) {
                        list.add(j, operations[i][1]);
                        break;
                    }
                }
            } else {
                list.remove(0);
            }
            result[i] = list.get(0);
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        list.add(root.val);
        dfs(root.left);
    }
}
