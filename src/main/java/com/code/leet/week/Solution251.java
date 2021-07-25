package com.code.leet.week;

import java.util.*;

public class Solution251 {

    public static void main(String[] args) {
        Solution251 solution = new Solution251();
//        System.out.println(solution.getLucky("leetcode", 2));
//        System.out.println(solution.maximumNumber("334111", new int[]{0, 9, 2, 3, 3, 2, 5, 5, 5, 5}));
        System.out.println(solution.maxCompatibilitySum(new int[][]{{0, 0}, {0, 0}, {0, 0}}, new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }

    public int getLucky(String s, int k) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            int num = ch - 'a' + 1;
            if (num > 9) {
                sum += num / 10 + num % 10;
            } else {
                sum += num;
            }
        }
        if (sum < 10 || k == 1) {
            return sum;
        }
        for (int i = 1; i < k; i++) {
            int result = 0;
            while (sum > 9) {
                result += sum % 10;
                sum /= 10;
            }
            sum += result;
            if (sum < 10) {
                break;
            }
        }
        return sum;
    }

    public String maximumNumber(String num, int[] change) {
        StringBuilder str = new StringBuilder();
        int flag = 0;
        int i = 0;
        for (; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (n > change[n] && flag == 1) {
                break;
            }
            if (n < change[n]) {
                str.append(change[n]);
                flag = 1;
            } else {
                str.append(n);
            }
        }
        return str + num.substring(i);
    }

    private int max = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        dfs(0, students, mentors, new ArrayList<>(), 0);
        return max;
    }

    private void dfs(int index, int[][] students, int[][] mentors, List<Integer> use, int sum) {
        if (index == students.length) {
            max = Math.max(max, sum);
            return;
        }
        int[] student = students[index];
        for (int i = 0; i < mentors.length; i++) {
            if (use.contains(i)) {
                continue;
            }
            int[] mentor = mentors[i];
            int count = 0;
            for (int j = 0; j < student.length; j++) {
                if (student[j] == mentor[j]) {
                    count++;
                }
            }
            use.add(i);
            sum += count;
            dfs(index + 1, students, mentors, use, sum);
            use.remove(use.size() - 1);
            sum -= count;
        }
    }
}
