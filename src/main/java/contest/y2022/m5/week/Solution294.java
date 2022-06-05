package contest.y2022.m5.week;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/22 10:42
 */
public class Solution294 {
    public static void main(String[] args) {

    }

    public int percentageLetter(String s, char letter) {
        int size = s.length();
        s = s.replace("" + letter, "");
        int l = s.length();
        return (size - l) * 100 / size;
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count = 0;
        for (int i = 0; i < rocks.length; i++) {
            rocks[i] = capacity[i] - rocks[i];
            if (rocks[i] <= 0) {
                count++;
            }
        }
        Arrays.sort(rocks);
        for (int i = count; i < rocks.length && additionalRocks > 0; i++) {
            if (additionalRocks >= rocks[i]) {
                count++;
                additionalRocks -= rocks[i];
            }
        }
        return count;
    }

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
        int[][] subs = new int[stockPrices.length - 1][2];
        for (int i = 0; i < stockPrices.length - 1; i++) {
            subs[i][0] = stockPrices[i + 1][0] - stockPrices[i][0];
            subs[i][1] = stockPrices[i + 1][1] - stockPrices[i][1];
        }
        long x = (long) subs[0][0];
        long y = (long) subs[0][1];
        int count = 1;
        for (int i = 1; i < subs.length; i++) {
            if (x * subs[i][1] != y * subs[i][0]) {
                count++;
                x = subs[i][0];
                y = subs[i][1];
            }
        }
        return count;
    }
}
