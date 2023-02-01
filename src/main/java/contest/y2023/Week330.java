package contest.y2023;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Week330 {

    public static void main(String[] args) {
        Week330 solution = new Week330();
//        System.out.println(solution.monkeyMove(55));
        System.out.println(solution.countQuadruplets(new int[]{1, 3, 2, 4, 5}));
    }

    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }

    public int monkeyMove(int n) {
        BigInteger mod = new BigInteger("1000000007");
        int ans = new BigInteger("2").modPow(new BigInteger("" + n), mod).intValue();
        return (ans - 2 + 1000000007) % 1000000007;
    }

    public long putMarbles(int[] weights, int k) {
        long[][] arrs = new long[weights.length][2];
        for (int i = 1; i < weights.length; i++) {
            arrs[i][0] = weights[i - 1] + weights[i];
            arrs[i][1] = i;
        }
        Arrays.sort(arrs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return (int) (o1[1] - o2[1]);
            }
            return (int) (o1[0] - o2[0]);
        });
        long min = 0;
        for (int i = 1; i < k; i++) {
            min += arrs[i][0];
        }
        Arrays.sort(arrs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return (int) (o2[1] - o1[1]);
            }
            return (int) (o2[0] - o1[0]);
        });
        long max = 0;
        for (int i = 0; i < k - 1; i++) {
            max += arrs[i][0];
        }
        return max - min;
    }

    public long countQuadruplets(int[] nums) {
        int[][] maxArr = new int[nums.length][nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            int max = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    max++;
                }
                maxArr[i][j] = max;
            }
        }
        long res = 0;
        for (int k = nums.length - 2; k > 1; k--) {
            long min = 0;
            for (int j = 0; j < nums.length - 2; j++) {
                if (nums[j] < nums[k]) {
                    min++;
                }
                if (nums[k] < nums[j]) {
                    res += min * maxArr[j][k];
                }
            }
        }
        return res;
    }
}
