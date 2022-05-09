package contest.y2022.m5.week;

import com.code.leet.entiy.TreeNode;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/5/8 10:29
 */
public class Solution292 {

    public static void main(String[] args) {
        Solution292 solution = new Solution292();
        solution.countTexts("22233");
    }

    /**
     * 第一题
     *
     * @param num
     * @return
     */
    public String largestGoodInteger(String num) {
        String str = "";
        for (int i = 9; i >= 0; i--) {
            str = "" + i + i + i;
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }

    /**
     * 第二题
     *
     * @param root
     * @return
     */
    public int averageOfSubtree(TreeNode root) {
        counts(root);
        sums(root);
        return count;
    }

    Queue<Integer> queue = new LinkedList<>();
    int count = 0;

    private int counts(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cnt = counts(root.left) + counts(root.right) + 1;
        queue.add(cnt);
        return cnt;
    }

    private int sums(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        sum += sums(root.left);
        sum += sums(root.right);
        if (sum / queue.poll() == root.val) {
            count++;
        }
        return sum;
    }

    /**
     * 第三题
     *
     * @param pressedKeys
     * @return
     */
    public int countTexts(String pressedKeys) {
        int[] cnts = new int[pressedKeys.length() + 1];
        cnts[0] = 1;
        cnts[1] = 1;
        int mod = 1000000007;
        for (int i = 1; i < pressedKeys.length(); i++) {
            cnts[i + 1] = cnts[i];
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                cnts[i + 1] += cnts[i - 1];
                cnts[i + 1] %= mod;
                if (i > 1 && pressedKeys.charAt(i) == pressedKeys.charAt(i - 2)) {
                    cnts[i + 1] += cnts[i - 2];
                    cnts[i + 1] %= mod;
                    if (i > 2 && pressedKeys.charAt(i) == pressedKeys.charAt(i - 3) && (pressedKeys.charAt(i) == '7' || pressedKeys.charAt(i) == '9')) {
                        cnts[i + 1] += cnts[i - 3];
                        cnts[i + 1] %= mod;
                    }
                }
            }
        }
        return cnts[pressedKeys.length()];
    }


    /**
     * 第四题
     *
     * @param grid
     * @return
     */
    //public boolean hasValidPath(char[][] grid) {
    //    xl = grid.length;
    //    yl = grid[0].length;
    //    return dfs(grid, 0, 0, 0);
    //}
    //
    //Set<String> set = new HashSet<>();
    //int xl;
    //int yl;
    //
    //private boolean dfs(char[][] grid, int x, int y, int cnt) {
    //    String s = "" + x + "-" + y + "-" + cnt;
    //    if (set.contains(s)) {
    //        return false;
    //    }
    //    set.add(s);
    //    if (x >= xl || y >= yl) {
    //        return false;
    //    }
    //    if (grid[x][y] == '(') {
    //        cnt++;
    //    } else {
    //        cnt--;
    //    }
    //    if (cnt < 0 || xl + yl - x - y < cnt) {
    //        return false;
    //    }
    //    if (x == xl - 1 && y == yl - 1 && cnt == 0) {
    //        return true;
    //    }
    //    return dfs(grid, x + 1, y, cnt) || dfs(grid, x, y + 1, cnt);
    //}
    public boolean hasValidPath(char[][] grid) {
        xl = grid.length;
        yl = grid[0].length;
        use = new boolean[xl][yl][xl * yl];
        if ((xl + yl) % 2 == 0 || grid[0][0] == ')' || grid[xl - 1][yl - 1] == '(') {
            return false;
        }
        dfs(grid, 0, 0, 0);
        return bl;
    }

    int xl;
    int yl;
    boolean bl = false;
    boolean[][][] use;

    private void dfs(char[][] grid, int x, int y, int cnt) {
        if (x >= xl || y >= yl || cnt > xl - x + yl - y - 1) {
            return;
        }
        if (x == xl - 1 && y == yl - 1) {
            bl = cnt == 1;
        }
        if (use[x][y][cnt]) {
            return;
        }
        use[x][y][cnt] = true;
        cnt += grid[x][y] == '(' ? 1 : -1;
        if (cnt < 0) {
            return;
        }
        if (!bl) {
            dfs(grid, x + 1, y, cnt);
        }
        if (!bl) {
            dfs(grid, x, y + 1, cnt);
        }
    }
}
