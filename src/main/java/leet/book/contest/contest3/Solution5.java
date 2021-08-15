package leet.book.contest.contest3;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        TreeNode root = new TreeNode(4);

    }

    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public int getDistance(TreeNode root, int num1, int num2) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> use = new ArrayList<>();
        for (TreeNode key : map.keySet()) {
            if (key.val == num1 || key.val == num2) {
                if (key.val == num2) {
                    num2 = num1;
                }
                List<TreeNode> list = map.get(key);
                use.add(key);
                queue.addAll(list);
                break;
            }
        }
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(use.contains(node)){
                    continue;
                }
                if(node.val==num2){
                    return count;
                }
                queue.addAll(map.get(node));
            }
            count++;
        }
        return 0;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = map.getOrDefault(root, new ArrayList<>());
        if (root.left != null) {
            list.add(root.left);
            List<TreeNode> llist = map.getOrDefault(root.left, new ArrayList<>());
            llist.add(root);
            map.put(root.left, llist);
        }
        if (root.right != null) {
            list.add(root.right);
            List<TreeNode> rlist = map.getOrDefault(root.right, new ArrayList<>());
            rlist.add(root);
            map.put(root.right, rlist);
        }
        map.put(root, list);
    }

}
