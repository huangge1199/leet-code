package contest.y2023;

import com.code.leet.entiy.TwoArray;

import java.util.*;

public class Week340 {
    public static void main(String[] args) {
        Week340 solution = new Week340();
//        TwoArray twoArray = new TwoArray("[[883,2,3],[5,6,7],[9,10,11]]", true);
//        solution.diagonalPrime(twoArray.getArr());
        solution.distance(new int[]{1, 3, 1, 1, 2});
    }

    public int minimumVisitedCells(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }
        boolean[][] use = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        use[0][0] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int val = grid[arr[0]][arr[1]];
                val += arr[1];
                for (int j = arr[1] + 1; j <= val && j < grid[0].length; j++) {
                    if (arr[0] == grid.length - 1 && j == grid[0].length - 1) {
                        return step;
                    }
                    if (!use[arr[0]][j]) {
                        queue.add(new int[]{arr[0], j});
                        use[arr[0]][j] = true;
                    }
                }
                val = val - arr[1] + arr[0];
                for (int j = arr[0] + 1; j <= val && j < grid.length; j++) {
                    if (j == grid.length - 1 && arr[1] == grid[0].length - 1) {
                        return step;
                    }
                    if (!use[j][arr[1]]) {
                        queue.add(new int[]{j, arr[1]});
                        use[j][arr[1]] = true;
                    }
                }
            }
        }
        return -1;
    }

    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        long[] res = new long[nums.length];
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            int size = list.size();
            long[] sums = new long[size];
            sums[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                sums[i] = sums[i - 1] + list.get(i);
            }
            res[list.get(0)] = sums[size - 1] - (long) size * list.get(0);
            for (int i = 1; i < list.size(); i++) {
                res[list.get(i)] = (long) i * list.get(i) - sums[i - 1] + sums[size - 1] - sums[i] - ((long) size - i - 1) * list.get(i);
            }
        }
        return res;
    }

    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                maxPrime = Math.max(maxPrime, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                maxPrime = Math.max(maxPrime, nums[i][n - i - 1]);
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
