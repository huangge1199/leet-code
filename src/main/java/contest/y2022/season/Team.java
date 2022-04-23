package contest.y2022.season;

import com.code.leet.entiy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/23 15:01
 */
public class Team {
    public static void main(String[] args) {
        Team solution = new Team();
        solution.conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0});
    }

    // p2
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int size = 0;
        for (int i = 0; i < matrix.length; i++) {
            size = Math.max(size, matrix[i].length());
        }
        use = new boolean[matrix.length][size];
        int count = 0;
        if (useNum(matrix, start, end)) {
            return count;
        }
        while (!counts.isEmpty()) {
            int nums = counts.size();
            count++;
            for (int i = 0; i < nums; i++) {
                int[] tmp = counts.poll();
                int tx = tmp[0];
                int ty = tmp[1];
                for (int j = 0; j < 4; j++) {
                    int x = tx + xt[j];
                    int y = ty + yt[j];
                    if (x == start[0] && y == start[1]) {
                        return count;
                    }
                    if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length() && !use[x][y]) {
                        if (useNum(matrix, start, new int[]{x, y})) {
                            return count;
                        }
                    }
                }
            }
        }
        return 0;
    }

    int[] xt = new int[]{1, -1, 0, 0};
    int[] yt = new int[]{0, 0, 1, -1};
    Queue<int[]> counts = new LinkedList<>();
    boolean[][] use;

    private boolean useNum(String[] matrix, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(end);
        counts.add(end);
        use[end[0]][end[1]] = true;
        char[] changes = new char[]{'^', 'v', '<', '>'};
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tx = tmp[0];
            int ty = tmp[1];

            for (int i = 0; i < 4; i++) {
                int x = tx + xt[i];
                int y = ty + yt[i];
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[x].length() && changes[i] == matrix[x].charAt(y) && !use[x][y]) {
                    if (x == start[0] && y == start[1]) {
                        return true;
                    }
                    use[x][y] = true;
                    queue.add(new int[]{x, y});
                    counts.add(new int[]{x, y});
                }
            }
        }
        return false;
    }

    //p6
    public int getMaxLayerSum(TreeNode root) {
        int max = root.val;
        Queue<RootV> queue = new LinkedList<>();
        if (root.left != null && root.right != null) {
            queue.add(new RootV(root, false));
        } else {
            queue.add(new RootV(root, true));
            if (root.left != null) {
                max = Math.max(max, root.left.val);
            } else {
                max = Math.max(max, root.right.val);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int score = 0;
            int add = 0;
            for (int i = 0; i < size; i++) {
                RootV rootV = queue.poll();
                TreeNode node = rootV.node;
                int tmp = node.val;
                if (null != node.left && node.right != null) {
                    if (rootV.bl) {
                        int sum = node.left.val + node.right.val;
                        if (sum > tmp) {
                            add = Math.max(add, sum - tmp);
                        }
                        queue.add(new RootV(node.left, true));
                        queue.add(new RootV(node.right, true));
                    } else {
                        queue.add(new RootV(node.left, false));
                        queue.add(new RootV(node.right, false));
                    }
                } else if (node.left != null) {
                    if (node.left.val > tmp) {
                        add = Math.max(add, node.left.val - tmp);
                    }
                    queue.add(new RootV(node.left, true));
                } else if (node.right != null) {
                    if (node.right.val > tmp) {
                        add = Math.max(add, node.right.val - tmp);
                    }
                    queue.add(new RootV(node.right, true));
                }
                score += tmp;
            }
            max = Math.max(max, score + add);
        }
        return max;
    }

    class RootV {
        TreeNode node;
        boolean bl;

        public RootV(TreeNode node, boolean bl) {
            this.node = node;
            this.bl = bl;
        }
    }
}
