package contest.y2021.m12.dw;

import com.code.leet.entiy.TwoArray;

import java.util.*;

public class SolutionD67 {
    public static void main(String[] args) {
        SolutionD67 solution = new SolutionD67();
//        solution.maxSubsequence(new int[]{50, -75}, 2);
//        solution.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
        TwoArray twoArray = new TwoArray("[[7,26,7],[7,18,4],[3,10,7],[17,50,1],[3,25,10],[85,23,8],[80,50,1],[58,74,1],[38,39,7],[50,51,8],[31,99,3],[53,6,5],[59,27,10],[87,78,9],[68,58,3]]", true);
        System.out.println(solution.maximumDetonation(twoArray.getArr()));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int size = nums.length;
        int[] indexs = Arrays.copyOf(nums, size);
        int[] arr = new int[k];
        Arrays.sort(indexs);
        int min = indexs[size - k];
        int count = 1;
        for (int i = size - k + 1; i < size; i++) {
            if (indexs[i] > indexs[size - k]) {
                break;
            }
            count++;
        }
        int index = 0;
        for (int num : nums) {
            if (num > min) {
                arr[index] = num;
                index++;
            }
            if (num == min && count > 0) {
                arr[index] = num;
                index++;
                count--;
            }
        }
        return arr;
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        int days = security.length;
        if (time == 0) {
            for (int i = 0; i < days; i++) {
                list.add(i);
            }
            return list;
        }
        if (time * 2 + 1 > days) {
            return list;
        }
        int[] starts = new int[days];
        int[] ends = new int[days];
        for (int i = 1; i < days; i++) {
            if (security[i] <= security[i - 1]) {
                starts[i] = starts[i - 1] + 1;
            }
            if (security[days - 1 - i] <= security[days - i]) {
                ends[days - 1 - i] = ends[days - i] + 1;
            }
        }
        for (int i = 0; i < days; i++) {
            if (starts[i] >= time && ends[i] >= time) {
                list.add(i);
            }
        }
        return list;
    }

    public int maximumDetonation(int[][] bombs) {
        int count = bombs.length;
        boolean[] uses = new boolean[count];
        int max = 1;
        for (int i = 0; i < count; i++) {
            if (uses[i]) {
                continue;
            }
            int temp = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{bombs[i][0], bombs[i][1], bombs[i][2], i});
            while (!queue.isEmpty()) {
                int[] bomb = queue.poll();
                for (int j = 0; j < count; j++) {
                    if (uses[j] || j == bomb[3]) {
                        continue;
                    }
                    long pos = ((long) bomb[0] - bombs[j][0]) * (bomb[0] - bombs[j][0]) + ((long) bomb[1] - bombs[j][1]) * (bomb[1] - bombs[j][1]);
                    if (pos <= (long) bomb[2] * bomb[2] || pos <= (long) bombs[j][2] * bombs[j][2]) {
                        temp++;
                        queue.add(new int[]{bombs[j][0], bombs[j][1], bombs[j][2], j});
                        uses[j] = true;
                        uses[bomb[3]] = true;
                    }
                }
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
