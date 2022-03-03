package contest.y2022.m2.week;

import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution282 {
    public static void main(String[] args) {
        Solution282 solution = new Solution282();
        TwoArray twoArray = new TwoArray("[[2,3],[3,4]]", true);
        System.out.println(solution.minimumFinishTime(twoArray.getArr(), 5, 4));
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public int minSteps(String s, String t) {
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chs[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (chs[i] < 0) {
                count -= chs[i];
            } else if (chs[i] > 0) {
                count += chs[i];
            }
        }
        return count;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long min = 1;
        long max = (long) time[time.length - 1] * totalTrips;
        while (min < max) {
            long mid = (min + max) / 2;
            long temp = 0;
            for (int j : time) {
                temp += mid / j;
            }
            if (temp < totalTrips) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        Queue<Integer> queue = new PriorityQueue<>();

        int[][] arrs = new int[tires.length][numLaps];
        for (int i = 0; i < numLaps; i++) {
            Queue<Integer> temp = new PriorityQueue<>();
            for (int j = 0; j < tires.length; j++) {
                if (i == 0) {
                    arrs[j][0] = tires[j][0];
                    temp.add(tires[j][0]);
                } else {
                    int mul = queue.peek();
                    arrs[j][i] = Math.min(mul + changeTime + tires[j][0], tires[j][0] * tires[j][1] + arrs[j][i - 1]);
                    temp.add(arrs[j][i]);
                }
            }
            queue = temp;
        }
        int result = arrs[0][numLaps - 1];
        for (int i = 1; i < tires.length; i++) {
            result = Math.min(result, arrs[i][numLaps - 1]);
        }
        return result;
    }
}
