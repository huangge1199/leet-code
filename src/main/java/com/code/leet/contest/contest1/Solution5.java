package com.code.leet.contest.contest1;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.solve("abccaba"));
    }

    public int solve(String tmp) {
//        return dfs(tmp, "abcba");
        return 0;
    }

    private int dfs(String str, String target) {
        if (str.equals(target)) {
            return 1;
        }
        if (target.equals("")) {
            return 0;
        }
        int index = str.indexOf(target.charAt(0));
        int count = 0;
        while (index >= 0) {
            str = str.substring(index + 1);
            count += dfs(str, target.substring(1));
            count %= 1000000007;
            index = str.indexOf(target.charAt(0));
        }
        return count;
    }
}
