package contest.y2022.m11;

import com.code.leet.entiy.TreeNode;

import java.util.*;

public class Week320 {
    public static void main(String[] args) {
        Week320 solution = new Week320();
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                minheap.add(node.val);
                maxheap.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        int[][] arrs = new int[queries.size()][2];
        Collections.sort(queries);
        for (int i = 0; i < queries.size(); i++) {
            int min = -1;
            if (minheap.isEmpty()) {
                arrs[i][0] = -1;
            } else {
                min = minheap.poll();
                while (min <= queries.get(i)) {
                    if (minheap.isEmpty()) {
                        break;
                    }
                    min = minheap.poll();
                }
            }
            arrs[i][0] = min;
            int max = -1;
            if (maxheap.isEmpty()) {
                arrs[queries.size() - i - 1][0] = -1;
            } else {
                max = maxheap.poll();
                while (max >= queries.get(i)) {
                    if (maxheap.isEmpty()) {
                        break;
                    }
                    max = maxheap.poll();
                }
            }
            arrs[queries.size() - i - 1][1] = max;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr : arrs) {
            list.add(Arrays.asList(arr[0], arr[1]));
        }
        return list;
    }

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() < 3) {
            return 0;
        }
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int tmp = list.get(i) * list.get(j);
                for (int k = j + 1; k < list.size(); k++) {
                    res += tmp * list.get(k);
                }
            }
        }
        return res;
    }
}
