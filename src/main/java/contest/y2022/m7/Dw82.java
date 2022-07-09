package contest.y2022.m7;

import com.code.leet.entiy.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class Dw82 {

    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        } else if (root.val == 1) {
            return true;
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < buses.length; i++) {
            int tmp = capacity;
            if (i == buses.length - 1) {
                for (; index < passengers.length && tmp > 1; index++) {
                    if (passengers[index] <= buses[i]) {
                        tmp--;
                        stack.push(passengers[index]);
                    }
                }
                break;
            }
            if (index == passengers.length) {
                break;
            }
            for (; index < passengers.length && tmp > 0; index++) {
                if (passengers[index] > buses[i]) {
                    break;
                }
                tmp--;
                stack.push(passengers[index]);
            }
        }
        int result = buses[buses.length - 1];
        if (index == passengers.length || result < passengers[index]) {
            if (stack.isEmpty() || result > stack.peek()) {
                return result;
            }
            result = stack.peek();
        }
        if (index < passengers.length) {
            result = Math.min(result, passengers[index]);
        }
        result--;
        while (!stack.isEmpty() && result == stack.peek()) {
            stack.pop();
            result--;
        }
        return result;
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int size = nums1.length;
        int[] subs = new int[size];
        for (int i = 0; i < size; i++) {
            subs[i] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(subs);
        int nums = k1 + k2;
        int count = 1;
        int sub = subs[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            int sum = (sub - subs[i]) * count;
            if (nums < sum) {
                break;
            }
            nums -= sum;
            count++;
            sub = subs[i];
            if (i == 0) {
                sum = sub * count;
                if (nums >= sum) {
                    return 0;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < size - count; i++) {
            result += (long) subs[i] * subs[i];
        }
        int s = nums / count;
        int y = nums % count;
        result += (long) (sub - s - 1) * (sub - s - 1) * y;
        result += (long) (sub - s) * (sub - s) * (count - y);
        return result;
    }

    public static void main(String[] args) {
        Dw82 solution = new Dw82();
        //solution.latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2);
        //solution.latestTimeCatchTheBus(new int[]{2}, new int[]{2}, 2);
        solution.minSumSquareDiff(new int[]{10, 10, 10, 11, 5}, new int[]{1, 0, 6, 6, 1}, 11, 27);
    }
}
