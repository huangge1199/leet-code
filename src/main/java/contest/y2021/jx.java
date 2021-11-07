package contest.y2021;

import com.code.leet.entiy.ListNode;
import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/10/29-19:00
 */
public class jx {

    public ListNode deleteListNode(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return head;
    }

    public int[] analysisHistogram(int[] heights, int cnt) {
        Arrays.sort(heights);
        int min = heights[heights.length - 1];
        int index = 0;
        for (int i = 0; i <= heights.length - cnt; i++) {
            int sub = heights[i + cnt - 1] - heights[i];
            if (sub < min) {
                min = sub;
                index = i;
            }
        }
        return Arrays.copyOfRange(heights, index, index + cnt - 1);
    }

    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        Map<Integer, List<Integer>> inMap = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            int[] line = lines[i];
            for (int j = 0; j < line.length; j++) {
                List<Integer> list = inMap.getOrDefault(line[j], new ArrayList<>());
                list.add(i);
                inMap.put(line[j], new ArrayList<>(list));
                list = nextMap.getOrDefault(line[j], new ArrayList<>());
                if (j > 0 && (!list.contains(line[j - 1]))) {
                    list.add(line[j - 1]);
                }
                if (j < line.length - 1 && (!list.contains(line[j + 1]))) {
                    list.add(line[j + 1]);
                }
                nextMap.put(line[j], new ArrayList<>(list));
            }
        }
        Queue<int[]> queue = new LinkedList<>();

        return null;
    }

    //    public int electricityExperiment(int row, int col, int[][] position) {
//        Arrays.sort(position, Comparator.comparingInt(a -> a[1]));
//        dfs(position, position[0][0], position[0][1], 0, row);
//        return count;
//    }
//
//    int count = 0;
//
//    private void dfs(int[][] position, int x, int y, int index, int row) {
//        if (y == position[position.length - 1][1]) {
//            if (x == position[position.length - 1][0]) {
//                count++;
//            }
//        }
//        if (index == position.length || (y == position[index][1] && x != position[index][0])) {
//            return;
//        }
//        index = y == position[index][1] && x == position[index][0] ? index + 1 : index;
//        if (x > 0) {
//            dfs(position, x - 1, y + 1, index, row);
//        }
//        dfs(position, x, y + 1, index, row);
//        if (x < row) {
//            dfs(position, x + 1, y + 1, index, row);
//        }
//    }

    public static void main(String[] args) {
        jx jx = new jx();
        TwoArray twoArray = new TwoArray("[[1,3],[3,5],[2,0]]",true);

        System.out.println(jx.electricityExperiment(5,6, twoArray.getArr()));
    }

    public int electricityExperiment(int row, int col, int[][] position) {
        Arrays.sort(position, Comparator.comparingInt(a -> a[1]));
        int[][] arrs = new int[row][col];
        arrs[position[0][0]][position[0][1]] = 1;
        int index = 1;
        for (int i = position[0][1] + 1; i <= position[position.length - 1][1]; i++) {
            for (int j = 0; j < row; j++) {
                if (j > 0) {
                    arrs[j][i] += arrs[j - 1][i - 1];
                }
                arrs[j][i] += arrs[j][i - 1];
                if (j < row - 1) {
                    arrs[j][i] += arrs[j + 1][i - 1];
                }
            }
        }
        for (int[] pos : position) {
            if (arrs[pos[0]][pos[1]] == 0) {
                return 0;
            }
        }
        return arrs[position[position.length - 1][0]][position[position.length - 1][1]];
    }
}
