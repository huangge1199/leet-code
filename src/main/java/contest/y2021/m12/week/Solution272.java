package contest.y2021.m12.week;


import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution272 {
    public static void main(String[] args) {
        Solution272 solution = new Solution272();
//        solution.addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15});
//        solution.getDescentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7});
        System.out.println(solution.kIncreasing(new int[]{5,4,3,2,1},1));
    }

    public String firstPalindrome(String[] words) {
        for (String str : words) {
            if ((new StringBuffer(str).reverse().toString()).equals(str)) {
                return str;
            }
        }
        return "";
    }

    public String addSpaces(String s, int[] spaces) {
//        for (int i = spaces.length - 1; i >= 0; i--) {
//            s = s.substring(0, spaces[i]) + " " + s.substring(spaces[i]);
//        }
//        return s;
        Queue<Character> queue = new LinkedList<>();
        char[] chs = s.toCharArray();
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            if (index < spaces.length && i == spaces[index]) {
                queue.add(' ');
                index++;
            }
            queue.add(chs[i]);
        }
        StringBuilder sBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            sBuilder.append(queue.poll());
        }
        s = sBuilder.toString();
        return s;
    }

    public long getDescentPeriods(int[] prices) {
        if (prices.length < 3) {
            return prices.length;
        }
        long count = 0;
        long sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count++;
            } else {
                if (count > 0) {
                    sum += (1 + count) * count / 2;
                }
                count = 0;
            }
        }
        if (count > 0) {
            sum += (1 + count) * count / 2;
        }
        return sum + prices.length;
    }

    public int kIncreasing(int[] arr, int k) {
        if (arr.length <= k) {
            return 0;
        }
        dfs(arr, k, k, 0);
        return min;
    }

    int min = Integer.MAX_VALUE;

    private void dfs(int[] arr, int k, int index, int count) {
        if (index == arr.length) {
            min = Math.min(count, min);
            return;
        }
        if (arr[index - k] <= arr[index]) {
            dfs(arr, k, index + 1, count);
        }

        int temp = arr[index];
        arr[index] = arr[index - k];
        dfs(arr, k, index + 1, count + 1);
        arr[index] = temp;

        int[] temps = Arrays.copyOf(arr,arr.length);
        for (int i = index; i >= 0; i = i - k) {
            if (temps[i] > temps[index]) {
                temps[i] = temps[index];
            }
        }
        dfs(temps, k, index + 1, count + 1);
    }
}
