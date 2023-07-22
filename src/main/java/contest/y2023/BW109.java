package contest.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BW109 {
    public static void main(String[] args) {
        BW109 solution = new BW109();
//        int[] nums = new int[]{2,3,6,1,9,2};
//        int x = 5;
//        System.out.println(solution.maxScore(nums,x));
        System.out.println(solution.numberOfWays(4, 1));
    }

    public int numberOfWays(int n, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sum = (int) Math.pow(i, x);
            if (sum <= n) {
                list.add(sum);
            } else {
                break;
            }
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num : list) {
            for (int i = n; i >= num; i--) {
                dp[i] = (dp[i] + dp[i - num]) % 1000000007;
            }
        }
        return dp[n];
    }

    public long maxScore(int[] nums, int x) {
        long max = nums[0];
        long[] sum = new long[nums.length];
        Arrays.fill(sum, Integer.MIN_VALUE);
        sum[0] = nums[0];
        int n1 = -1;
        int n2 = -1;
        if (nums[0] % 2 == 0) {
            n2 = 0;
        } else {
            n1 = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (n1 >= 0) {
                sum[i] = Math.max(sum[i], (nums[i] % 2 == 0 ? sum[n1] + nums[i] - x : sum[n1] + nums[i]));
            }
            if (n2 >= 0) {
                sum[i] = Math.max(sum[i], (nums[i] % 2 == 0 ? sum[n2] + nums[i] : sum[n2] + nums[i] - x));
            }
            if (nums[i] % 2 == 0) {
                n2 = i;
            } else {
                n1 = i;
            }
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    public String sortVowels(String s) {
        String str = "aeiouAEIOU";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(String.valueOf(s.charAt(i)))) {
                list.add(String.valueOf(s.charAt(i)));
            }
        }
        Collections.sort(list);
        StringBuilder nstr = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(String.valueOf(s.charAt(i)))) {
                nstr.append(list.get(index));
                index++;
            } else {
                nstr.append(String.valueOf(s.charAt(i)));
            }
        }
        return nstr.toString();
    }

    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i + 1 != nums[i]) {
                return false;
            }
        }
        return nums[nums.length - 1] == nums.length - 1;
    }
}
