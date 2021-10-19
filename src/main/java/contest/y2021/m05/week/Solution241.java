package contest.y2021.m05.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/5/16 10:30
 * @Description:
 */
public class Solution241 {
    public static void main(String[] args) {
//        Solution241 solution = new Solution241();
//        System.out.println(solution.minSwaps("1110"));
//        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3},new int[]{1, 4, 5, 2, 5, 4});
//        System.out.println(findSumPairs.count(7));
//        findSumPairs.add(3,2);
//        findSumPairs.count(8);
//        findSumPairs.count(4);
//        findSumPairs.add(0,1);
//        findSumPairs.add(1,1);
//        findSumPairs.count(7);
        System.out.println(1^2);
    }

    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return getArr(nums, 0, new ArrayList<>(), 0);
    }

    private int getArr(int[] nums, int index, List<Integer> xors, int result) {
        if (index == nums.length) {
            return result;
        }
        List<Integer> temp = xors;
        for (int xor : temp) {
            result += xor ^ nums[index];
        }
        result += nums[index];
        xors.add(nums[index]);
        return getArr(nums, index + 1, xors, result);
    }

    public int minSwaps(String s) {
        int s0 = s.replace("0", "").length();
        int s1 = s.replace("1", "").length();
        if (Math.abs(s0 - s1) > 1) {
            return -1;
        }
        int com = 0;
        int m0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (com != s.charAt(i) - '0') {
                m0++;
            }
            com = 1 - com;
        }
        m0 = m0 % 2 == 0 ? m0 : Integer.MAX_VALUE;
        com = 1;
        int m1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (com != s.charAt(i) - '0') {
                m1++;
            }
            com = 1 - com;
        }
        m1 = m1 % 2 == 0 ? m1 : Integer.MAX_VALUE;
        return Math.min(m0, m1) / 2;
    }
}


