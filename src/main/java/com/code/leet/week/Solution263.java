package com.code.leet.week;

import com.code.leet.entiy.TwoArray;

import java.math.BigInteger;
import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution263 {
    public static void main(String[] args) {
        Solution263 solution = new Solution263();
//        solution.areNumbersAscending("hello world 5 x 5");
        TwoArray twoArray = new TwoArray("[[1,2],[1,3],[1,4],[3,4],[4,5]]", true);
        solution.secondMinimum(5, twoArray.getArr(), 3, 5);
    }

    public boolean areNumbersAscending(String s) {
        int num = -1;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                str = "" + s.charAt(i);
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    str += s.charAt(i);
                    i++;
                }
                if (num < Integer.parseInt(str)) {
                    num = Integer.parseInt(str);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    class Bank {
        long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 - 1 < balance.length && balance[account1 - 1] >= money && account2 - 1 < balance.length) {
                balance[account1 - 1] -= money;
                balance[account2 - 1] += money;
                return true;
            } else {
                return false;
            }
        }

        public boolean deposit(int account, long money) {
            if (account - 1 < balance.length) {
                balance[account - 1] += money;
                return true;
            } else {
                return false;
            }
        }

        public boolean withdraw(int account, long money) {
            if (account - 1 < balance.length && balance[account - 1] >= money) {
                balance[account - 1] -= money;
                return true;
            } else {
                return false;
            }
        }
    }

    int max = -1;
    int count = 1;

    public int countMaxOrSubsets(int[] nums) {
        dfs(0, nums, 0);
        return count;
    }

    private void dfs(int index, int[] nums, int res) {
        if (index == nums.length) {
            if (max == -1 || res > max) {
                max = res;
                count = 1;
            } else if (res == max) {
                count++;
            }
            return;
        }
        dfs(index + 1, nums, res | nums[index]);
        dfs(index + 1, nums, res);
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        int[] counts = new int[n + 1];
        while (!queue.isEmpty()) {
            int[] arrs = queue.peek();
            int free = arrs[1] + time;
            if ((arrs[1] / change) % 2 == 1) {
                free += change - arrs[1] % change;
            }
            int size = queue.size();
            boolean bl = true;
            boolean[] use = new boolean[n + 1];
            for (int i = 0; i < size; i++) {
                arrs = queue.poll();
                List<Integer> list = map.get(arrs[0]);
                for (int num : list) {
                    if (!use[num] && counts[num] < 2) {
                        queue.add(new int[]{num, free});
                        use[num] = true;
                        counts[num]++;
                    }
                    if (num == n && bl) {
                        bl = false;
                        if (counts[num] == 2) {
                            return free;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
