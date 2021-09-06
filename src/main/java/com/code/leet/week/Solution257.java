package com.code.leet.week;

import com.code.leet.entiy.TwoArray;

import java.math.BigInteger;
import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution257 {
    public static void main(String[] args) {
        Solution257 solution = new Solution257();
//        TwoArray twoArray = new TwoArray("[[1,1],[2,1],[2,2],[1,2]]", true);
//        System.out.println(solution.numberOfWeakCharacters(twoArray.getArr()));
        System.out.println(solution.firstDayBeenInAllRooms(new int[]{0, 0}));
    }

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < properties.length; i++) {
            if (set.higher(properties[i][1]) != null) {
                count++;
            }
            list.add(properties[i][1]);
            if (i != properties.length - 1 && properties[i][0] != properties[i + 1][0]) {
                set.addAll(list);
                list.clear();
            }
        }
        for (int i = properties.length - 1; i >= 0; i--) {
            if (i != properties.length - 1 && properties[i][0] != properties[i + 1][0] && set.higher(properties[i][1]) != null) {
                count++;
            }
            set.add(properties[i][1]);
        }
        return count;
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int[] dp = new int[nextVisit.length];
        int[] sum = new int[nextVisit.length];
        for (int i = 1; i < nextVisit.length; i++) {
            sum[i] = dp[i - 1] - dp[nextVisit[i - 1]];
            dp[i] = dp[i - 1] + sum[i];
        }
        return dp[nextVisit.length - 1];
    }
}
