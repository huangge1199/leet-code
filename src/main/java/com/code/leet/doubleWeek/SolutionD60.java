package com.code.leet.doubleWeek;

import java.math.BigInteger;
import java.util.*;

public class SolutionD60 {
    public static void main(String[] args) {
        SolutionD60 solution = new SolutionD60();
        solution.numberOfGoodSubsets(new int[]{4, 2, 3, 15});
    }

    public int findMiddleIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i < sums.length; i++) {
            if (sums[i - 1] == sums[sums.length - 1] - sums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public int[][] findFarmland(int[][] land) {
        boolean[][] use = new boolean[land.length][land[0].length];
        int[] xIndex = new int[]{1, 0};
        int[] yIndex = new int[]{0, 1};
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && !use[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    use[i][j] = true;
                    int[] temp = new int[]{i, j, i, j};
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        for (int k = 0; k < 2; k++) {
                            int x = arr[0] + xIndex[k];
                            int y = arr[1] + yIndex[k];
                            if (x >= land.length || y >= land[0].length || land[x][y] == 0 || use[x][y]) {
                                continue;
                            }
                            if (x > temp[2] || y > temp[3]) {
                                temp[2] = x;
                                temp[3] = y;
                            }
                            use[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                    }
                    list.add(temp);
                }
            }
        }
        int[][] result = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

//    class LockingTree {
//
//        int[] parent;
//        boolean[] isLock;
//        int[] userLock;
//
//        public LockingTree(int[] parent) {
//            this.parent = parent;
//            isLock = new boolean[parent.length];
//            userLock = new int[parent.length];
//            Arrays.fill(userLock, -1);
//        }
//
//        public boolean lock(int num, int user) {
//
//        }
//
//        public boolean unlock(int num, int user) {
//
//        }
//
//        public boolean upgrade(int num, int user) {
//
//        }
//    }

    long temp;

    public int numberOfGoodSubsets(int[] nums) {
        int[] counts = new int[31];
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 7, 10, 11, 13, 14, 15, 17, 19, 21, 22, 23, 29, 30));
        long sum = 0;
        for (int num : nums) {
            counts[num]++;
        }
        int count = 0;
        for (int i = 1; i < 31; i++) {
            if (list.contains(i)) {
                count += counts[i];
            }
        }
        if (counts[1] > 0) {
            sum += (long) counts[1] * count;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (counts[list.get(i)] == 0) {
                list.remove(i);
            }
        }
        Map<Integer, List<Integer>> pd = new HashMap<>();
        pd.put(2, Arrays.asList(2, 6, 10, 14, 22, 26, 30));
        pd.put(3, Arrays.asList(3, 6, 15, 21, 30));
        pd.put(5, Arrays.asList(5, 10, 15, 30));
        pd.put(7, Arrays.asList(7, 14, 21));
        pd.put(11, Arrays.asList(11, 22));
        pd.put(13, Arrays.asList(13, 26));
        pd.put(17, Collections.singletonList(17));
        pd.put(19, Collections.singletonList(19));
        pd.put(23, Collections.singletonList(23));
        pd.put(29, Collections.singletonList(29));
        boolean[] use = new boolean[31];
        dfs(list, use, 0, 0, pd, counts);
        sum += (long) nums[0] * (nums[0] + 1) / 2 * temp;
        return (int) (sum % 1000000007);
    }

    private void dfs(List<Integer> list, boolean[] use, long count, int index, Map<Integer, List<Integer>> pd, int[] counts) {
        if (index == list.size()) {
            temp = count;
        }
        int t = 0;
        boolean bl = true;
        List<Integer> l = new ArrayList<>();
        for (int key : pd.keySet()) {
            if (pd.get(key).contains(list.get(index))) {
                if (!use[key]) {
                    l.add(key);
                } else {
                    bl = false;
                }
            }
        }
        if (bl) {
            for (Integer integer : l) {
                use[integer] = true;
            }
            dfs(list, use, Math.max(0, 1) * counts[list.get(index)], index + 1, pd, counts);
            for (Integer integer : l) {
                use[integer] = false;
            }
        }
        dfs(list, use, count, index + 1, pd, counts);
    }
}
