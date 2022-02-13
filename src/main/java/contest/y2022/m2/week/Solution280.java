package contest.y2022.m2.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution280 {
    public static void main(String[] args) {
        Solution280 solution = new Solution280();
        System.out.println(solution.minimumOperations(new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79, 24}));
    }

    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
    }

    public int minimumOperations(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return 0;
        } else if (size == 2) {
            return nums[0] == nums[1] ? 1 : 0;
        }
        int[] odds = new int[size % 2 == 0 ? size / 2 : size / 2 + 1];
        int[] dous = new int[size / 2];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                odds[i / 2] = nums[i];
            } else {
                dous[i / 2] = nums[i];
            }
        }
        Arrays.sort(odds);
        Arrays.sort(dous);
        Map<Integer, List<Integer>> modds = new HashMap<>();
        int tc = 1;
        for (int i = 1; i < odds.length; i++) {
            if (odds[i] == odds[i - 1]) {
                tc++;
            } else {
                modds.computeIfAbsent(tc, key -> new ArrayList<>()).add(odds[i - 1]);
                tc=1;
            }
        }
        modds.computeIfAbsent(tc, key -> new ArrayList<>()).add(odds[odds.length - 1]);
        Integer[] aodds = new Integer[modds.size()];
        int index = 0;
        for (int key : modds.keySet()) {
            aodds[index] = key;
            index++;
        }
        Arrays.sort(aodds,Collections.reverseOrder());

        tc = 1;
        Map<Integer, List<Integer>> mdous = new HashMap<>();
        for (int i = 1; i < dous.length; i++) {
            if (dous[i] == dous[i - 1]) {
                tc++;
            } else {
                mdous.computeIfAbsent(tc, key -> new ArrayList<>()).add(dous[i - 1]);
                tc=1;
            }
        }
        mdous.computeIfAbsent(tc, key -> new ArrayList<>()).add(dous[dous.length - 1]);
        Integer[] adous = new Integer[mdous.size()];
        index = 0;
        for (int key : mdous.keySet()) {
            adous[index] = key;
            index++;
        }
        Arrays.sort(adous,Collections.reverseOrder());
        List<Integer> lodds = modds.get(aodds[0]);
        List<Integer> ldous = mdous.get(adous[0]);
        if (!lodds.get(0).equals(ldous.get(0)) || modds.get(aodds[0]).size() > 1 || modds.get(adous[0]).size() > 1) {
            return size - aodds[0] - adous[0];
        } else {
            if (modds.get(aodds[0]).size() == 1 && modds.get(adous[0]).size() == 1) {
                return adous[0];
            } else if (modds.get(aodds[0]).size() == 1) {
                return size - aodds[0] - adous[1];
            } else if (modds.get(adous[0]).size() == 1) {
                return size - aodds[1] - adous[0];
            } else {
                return Math.min(size - aodds[0] - adous[1], size - aodds[1] - adous[0]);
            }
        }
    }
}
