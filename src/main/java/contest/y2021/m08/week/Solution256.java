package contest.y2021.m08.week;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution256 {
    public static void main(String[] args) {
        Solution256 solution = new Solution256();
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }

    public String kthLargestNumber(String[] nums, int k) {
        BigInteger[] num = new BigInteger[nums.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = new BigInteger(nums[i]);
        }
        Arrays.sort(num);
        return String.valueOf(num[num.length - k]);
    }

    //    public int minSessions(int[] tasks, int sessionTime) {
//        Arrays.sort(tasks);
//        int start = 0;
//        int end = tasks.length - 1;
//        int count = 0;
//        int sum = tasks[end];
//        while (start < end) {
//            sum += tasks[start];
//            if (sum > sessionTime) {
//                end--;
//                sum = tasks[end];
//                count++;
//            } else if (sum == sessionTime) {
//                start++;
//                end--;
//                sum = tasks[end];
//                count++;
//            } else {
//                start++;
//            }
//        }
//        return start == end ? count + 1 : count;
//    }
}
