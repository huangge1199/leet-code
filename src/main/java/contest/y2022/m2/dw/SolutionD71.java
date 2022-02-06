package contest.y2022.m2.dw;

import java.util.*;

public class SolutionD71 {
    public static void main(String[] args) {
        SolutionD71 solution = new SolutionD71();
    }

    public int minimumSum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num >= 10) {
            int temp = num % 10;
            if (temp > 0) {
                list.add(temp);
            }
            num /= 10;
        }
        list.add(num);
        Collections.sort(list);
        int size = list.size();
        int result = 0;
        switch (size) {
            case 1:
                result = list.get(0);
                break;
            case 2:
                result = list.get(0) + list.get(1);
                break;
            case 3:
                result = list.get(0) * 10 + list.get(1) + list.get(2);
                break;
            case 4:
                result = list.get(0) * 10 + list.get(1) * 10 + list.get(2) + list.get(3);
                break;
            default:
                break;
        }
        return result;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num == pivot) {
                count++;
            } else if (num < pivot) {
                small.add(num);
            } else {
                large.add(num);
            }
        }
        int[] results = new int[nums.length];
        int index = 0;
        for (int num : small) {
            results[index] = num;
            index++;
        }
        for (int i = 0; i < count; i++) {
            results[index] = pivot;
            index++;
        }
        for (int num : large) {
            results[index] = num;
            index++;
        }
        return results;
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ss = targetSeconds % 60;
        int mm = targetSeconds / 60;
        if (mm == 100) {
            mm = 99;
            ss += 60;
        }
        int[] nums = new int[4];
        nums[0] = mm / 10;
        nums[1] = mm % 10;
        nums[2] = ss / 10;
        nums[3] = ss % 10;
        int cost1 = 0;
        int temp = startAt;
        int i = 0;
        for (; i < 4; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        for (; i < 4; i++) {
            if (nums[i] == temp) {
                cost1 += pushCost;
            } else {
                cost1 += moveCost + pushCost;
                temp = nums[i];
            }
        }
        if (targetSeconds < 60 || ss >= 40) {
            return cost1;
        }
        ss += 60;
        mm -= 1;
        nums[0] = mm / 10;
        nums[1] = mm % 10;
        nums[2] = ss / 10;
        nums[3] = ss % 10;
        int cost2 = 0;
        temp = startAt;
        i = 0;
        for (; i < 4; i++) {
            if (nums[i] > 0) {
                break;
            }
        }
        for (; i < 4; i++) {
            if (nums[i] == temp) {
                cost2 += pushCost;
            } else {
                cost2 += moveCost + pushCost;
                temp = nums[i];
            }
        }
        return Math.min(cost1, cost2);
    }
}
