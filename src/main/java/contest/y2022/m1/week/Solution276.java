package contest.y2022.m1.week;

import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution276 {
    public static void main(String[] args) {
        Solution276 solution = new Solution276();
//        solution.divideString("abcdefghij", 3, 'x');
        TwoArray twoArray = new TwoArray("[[3,2],[4,3],[4,4],[2,5]]", true);
        System.out.println(solution.mostPoints(twoArray.getArr()));
    }

    public String[] divideString(String s, int k, char fill) {
        char[] chs = s.toCharArray();
        int length = s.length() % k == 0 ? s.length() / k : s.length() / k + 1;
        String[] strs = new String[length];
        Arrays.fill(strs, "");
        int index = 0;
        for (char ch : chs) {
            if (strs[index].length() == k) {
                index++;
            }
            strs[index] += ch;
        }
        for (int i = strs[index].length(); i < k; i++) {
            strs[index] += fill;
        }
        return strs;
    }

    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target > 1) {
            if (maxDoubles == 0) {
                break;
            }
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target--;
            }
            count++;
        }
        return target == 1 ? count : count + target - 1;
    }

    public long mostPoints(int[][] questions) {
        Map<Integer, Integer> map = new HashMap<>();
        long[][] nums = new long[questions.length][2];
        long max = 0;
        for (int i = 0; i < questions.length; i++) {
            if (i > 0) {
                nums[i][0] = Math.max(nums[i][0], nums[i - 1][0]);
            }
            nums[i][1] = nums[i][0] + questions[i][0];
            if (i + questions[i][1] + 1 < questions.length) {
                nums[i + questions[i][1] + 1][0] = Math.max(nums[i + questions[i][1] + 1][0], nums[i][1]);
            }
            max = Math.max(nums[i][1], max);
        }
        return max;
    }

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        long min = 0;
        for (int battery : batteries) {
            sum += battery;
            min = Math.min(min, battery);
        }
        return batteries.length == n ? min : sum / n;
    }
}
