package contest.y2021.m08.week;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution252 {
    public static void main(String[] args) {
        Solution252 solution = new Solution252();
        System.out.println(solution.findDifferentBinaryString(new String[]{"0"}));
    }

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for (int i = min; i >= 1; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        List<String> list = Arrays.asList(nums);
        int max = (int) Math.pow(2, n);
        for (int i = max - 1; i >= 1; i--) {
            if (!list.contains(Integer.toBinaryString(i))) {
                String temp = Integer.toBinaryString(i);
                while (temp.length() < n) {
                    temp = "0" + temp;
                }
                return temp;
            }
        }
        return null;
    }
}
