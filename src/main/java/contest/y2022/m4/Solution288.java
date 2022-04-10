package contest.y2022.m4;

import javax.management.Query;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution288 {
    public static void main(String[] args) {
        Solution288 solution = new Solution288();
//        solution.minimizeResult("247+38");
        solution.maximumProduct(new int[]{7, 8, 9}, 9);
    }

    public int largestInteger(int num) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String s = String.valueOf(num);
        int[] nums = new int[s.length()];
        int index = 0;
        for (char ch : s.toCharArray()) {
            if ((ch - '0') % 2 == 0) {
                list2.add(ch - '0');
            } else {
                list1.add(ch - '0');
                nums[index] = 1;
            }
            index++;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int i1 = list1.size() - 1;
        int i2 = list2.size() - 1;
        num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] == 0) {
                num = num * 10 + list2.get(i2);
                i2--;
            } else {
                num = num * 10 + list1.get(i1);
                i1--;
            }
        }
        return num;
    }


    public String minimizeResult(String expression) {
        String[] strs = expression.split("\\+");
        int sum = Integer.MAX_VALUE;
        String str = "";
        for (int i = 0; i < strs[0].length(); i++) {
            int num00 = i > 0 ? Integer.valueOf(strs[0].substring(0, i)) : 1;
            int num01 = Integer.valueOf(strs[0].substring(i));
            for (int j = 1; j <= strs[1].length(); j++) {
                int num10 = Integer.valueOf(strs[1].substring(0, j));
                int num11 = j == strs[1].length() ? 1 : Integer.valueOf(strs[1].substring(j));
                int tmp = num00 * (num01 + num10) * num11;
                if (tmp < sum) {
                    str = "" + (i == 0 ? "" : num00) + "(" + num01 + "+" + num10 + ")" + (j == strs[1].length() ? "" : num11);
                    sum = tmp;
                }
            }
        }
        return str;
    }

    public int maximumProduct(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] + k;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        while (k > 0) {
            int min = queue.poll();
            int sub = queue.peek() - min + 1;
            if (sub < k) {
                min = queue.peek() + 1;
                k -= sub;
            } else {
                min += k;
                k = 0;
            }
            queue.add(min);
        }
        long mul = 1;
        int mod = 1000000007;
        while (!queue.isEmpty()) {
            mul = (mul * queue.poll()) % mod;
        }
        return (int) mul;
    }
}