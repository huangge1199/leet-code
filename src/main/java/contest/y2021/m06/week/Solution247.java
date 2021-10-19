package contest.y2021.m06.week;

import java.util.*;

public class Solution247 {
    public static void main(String[] args) {
        Solution247 solution = new Solution247();
        solution.rotateGrid(new int[][]{{40,10},{30,20}},1);
    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        return nums[size - 1] * nums[size - 2] - nums[0] * nums[1];
    }


    public int[][] rotateGrid(int[][] grid, int k) {
        int xSize = grid.length;
        int ySize = grid[0].length;
        int round = Math.min(xSize, ySize) / 2;
        for (int i = 0; i < round; i++) {
            int sum = (xSize - 1 - i) * 2 + (ySize - 1 - i) * 2;
            int temp = k % sum;
            if (temp == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int y = i; y < ySize - i - 1; y++) {
                list.add(grid[i][y]);
            }
            for (int x = i; x < xSize - i - 1; x++) {
                list.add(grid[x][ySize - i - 1]);
            }
            for (int y = ySize - i - 1; y > i; y--) {
                list.add(grid[xSize - i - 1][y]);
            }
            for (int x = xSize - i - 1; x > i; x--) {
                list.add(grid[x][i]);
            }
            List<Integer> trans = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j + k < list.size()) {
                    trans.add(list.get(j + k));
                } else {
                    trans.add(list.get(j + k - trans.size()));
                }
            }
            int index=0;
            for (int y = i; y < ySize - i - 1; y++) {
                grid[i][y] = trans.get(index);
                index++;
            }
            for (int x = i; x < xSize - i - 1; x++) {
                grid[x][ySize - i - 1] = trans.get(index);
                index++;
            }
            for (int y = ySize - i - 1; y > i; y--) {
                grid[xSize - i - 1][y] = trans.get(index);
                index++;
            }
            for (int x = xSize - i - 1; x > i; x--) {
                grid[x][i] = trans.get(index);
                index++;
            }
        }
        return grid;
    }

//    public long wonderfulSubstrings(String word) {
//        char[] chs = word.toCharArray();
//        int count = chs.length;
//        for (int i = 0; i < chs.length; i++) {
//            Map<Character, Integer> map = new HashMap<>();
//            map.put(chs[i], 1);
//            int odd = 1;
//            int enev = 0;
//            for (int j = i + 1; j < chs.length; j++) {
//                int num = map.getOrDefault(chs[j], 0) + 1;
//                if (num % 2 == 1) {
//                    odd++;
//                    enev--;
//                } else {
//                    odd--;
//                    enev++;
//                }
//                if (odd < 2) {
//                    count++;
//                }
//                map.put(chs[j],num);
//            }
//        }
//        return count;
//    }
}
