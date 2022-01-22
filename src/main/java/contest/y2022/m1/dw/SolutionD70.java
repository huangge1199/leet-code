package contest.y2022.m1.dw;

import javafx.util.Pair;

import java.util.*;

public class SolutionD70 {
    public static void main(String[] args) {
        SolutionD70 solution = new SolutionD70();
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int size = cost.length;
        for (int i = 0; i < size; i++) {
            if (i % 3 == 2) {
                continue;
            }
            sum += cost[size - 1 - i];
        }
        return sum;
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = upper;
        long max = lower;
        long value = lower;
        for (int difference : differences) {
            value += difference;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return (int) Math.max(upper - max - Math.max(lower - min, 0) + 1, 0);
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int xl = grid.length;
        int yl = grid[0].length;
        boolean[][] use = new boolean[xl][yl];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{grid[start[0]][start[1]], start[0], start[1]});
        use[start[0]][start[1]] = true;
        int[] xi = new int[]{-1, 1, 0, 0};
        int[] yi = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                if (grid[arr[1]][arr[2]] >= pricing[0] && grid[arr[1]][arr[2]] <= pricing[1]) {
                    temp.add(arr);
                }
                for (int j = 0; j < 4; j++) {
                    int x = arr[1] + xi[j];
                    int y = arr[2] + yi[j];
                    if (x < 0 || x >= xl || y < 0 || y >= yl || use[x][y] || grid[x][y] == 0) {
                        continue;
                    }
                    queue.add(new int[]{grid[x][y], x, y});
                    use[x][y] = true;
                }
            }
            temp.sort((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            });
            for (int[] arr : temp) {
                list.add(Arrays.asList(arr[1], arr[2]));
                k--;
                if (k == 0) {
                    break;
                }
            }
        }
        return list;
    }

    public int numberOfWays(String corridor) {
        String temp = corridor;
        corridor = corridor.replace("P", "");
        if (corridor.length() % 2 == 1 || corridor.length() == 0) {
            return 0;
        }
        int last = temp.lastIndexOf('S');
        int end = temp.substring(0, last).lastIndexOf('S');
        temp = temp.substring(0, end + 1);
        char[] chs = temp.toCharArray();
        boolean is = false;
        int count = 0;
        int scount = 0;
        long mul = 1;
        for (char ch : chs) {
            if (ch == 'S') {
                if (is) {
                    is = false;
                    mul *= count;
                    scount = 1;
                } else if (scount == 1) {
                    is = true;
                    count = 1;
                } else {
                    scount++;
                }
            } else {
                if (is) {
                    count++;
                }
            }
        }
        return (int) (mul % 1000000007);
    }
}
