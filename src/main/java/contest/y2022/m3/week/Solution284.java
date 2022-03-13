package contest.y2022.m3.week;

import com.code.leet.entiy.TreeNode;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution284 {
    public static void main(String[] args) {
        Solution284 solution = new Solution284();
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = Math.max(max + 1, i - k); j < Math.min(nums.length, i + k + 1); j++) {
                    if (!list.contains(j)) {
                        list.add(j);
                    }
                }
                max = Math.min(nums.length - 1, i + k);
                if (max == nums.length - 1) {
                    break;
                }
            }
        }
        return list;
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] use = new boolean[n][n];
        for (int[] ints : dig) {
            use[ints[0]][ints[1]] = true;
        }
        int count = 0;
        for (int[] arttifact : artifacts) {
            int x1 = arttifact[0];
            int y1 = arttifact[1];
            int x2 = arttifact[2];
            int y2 = arttifact[3];
            boolean temp = true;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (!use[i][j]) {
                        temp = false;
                        break;
                    }
                }
            }
            if (temp) {
                count++;
            }
        }
        return count;
    }
}
