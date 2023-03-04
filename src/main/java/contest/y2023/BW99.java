package contest.y2023;

import com.code.leet.entiy.TwoArray;

import java.util.*;

public class BW99 {
    public static void main(String[] args) {
        BW99 solution = new BW99();
    }

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int sum = 2;
        int max = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] > max) {
                sum *= 2;
                sum %= 1000000007;
                max = ranges[i][1];
            } else {
                max = Math.max(max, ranges[i][1]);
            }
        }
        return sum;
    }

    public long coloredCells(int n) {
        return ((long) n - 1) * (n - 1) + (long) n * n;
    }

    public int splitNum(int num) {
        String str = "" + num;
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        int num1 = 0;
        int num2 = 0;
        int index = 0;
        while (strs[index] - '0' == 0) {
            index++;
        }
        for (int i = index; i < strs.length; i++) {
            if (i % 2 == index % 2) {
                num1 = num1 * 10 + (strs[i] - '0');
            } else {
                num2 = num2 * 10 + (strs[i] - '0');
            }
        }
        return num1 + num2;
    }

}
