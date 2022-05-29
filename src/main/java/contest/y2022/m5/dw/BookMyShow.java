package contest.y2022.m5.dw;

import java.util.*;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/28 下午11:27
 */
public class BookMyShow {
    TreeSet<int[]> treeSet = new TreeSet<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

    public BookMyShow(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                treeSet.add(new int[]{i, j});
            }
        }
    }

    public int[] gather(int k, int maxRow) {
        Stack<int[]> stack = new Stack<>();
        int nums = k;
        for (int i = 0; i <= maxRow && nums > 0; i++) {
            for (int[] arr : treeSet.tailSet(new int[]{i, 0})) {
                if (stack.isEmpty()) {
                    stack.add(arr);
                    nums--;
                } else {
                    int[] tmp = stack.peek();
                    if (tmp[0] > maxRow) {
                        break;
                    }
                    if (tmp[0] == arr[0] && arr[1] - tmp[1] == 1) {
                        stack.add(arr);
                        nums--;
                    } else {
                        stack = new Stack<>();
                        stack.add(arr);
                        nums = k - 1;
                    }
                }
                if (nums == 0) {
                    break;
                }
            }
        }
        int[] arr = new int[2];
        if (nums == 0) {
            arr = stack.firstElement();
            while (!stack.isEmpty()) {
                treeSet.remove(stack.pop());
            }
        }
        return nums == 0 ? arr : new int[0];
    }

    public boolean scatter(int k, int maxRow) {
        if (treeSet.size() < k) {
            return false;
        }
        Stack<int[]> stack = new Stack<>();
        int nums = k;
        while (!treeSet.isEmpty() && nums > 0) {
            int[] arr = treeSet.first();
            if (arr[0] > maxRow) {
                while (!stack.isEmpty()) {
                    treeSet.add(stack.pop());
                }
                return false;
            }
            stack.add(arr);
            treeSet.remove(arr);
            nums--;
        }
        return true;
    }
}
