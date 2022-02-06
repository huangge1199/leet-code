package contest.y2022.m2.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution279 {
    public static void main(String[] args) {
        Solution279 solution = new Solution279();
        Bitset bitset = new Bitset(5);
        bitset.fix(3);
        bitset.fix(1);
        bitset.flip();
        bitset.all();
        bitset.unfix(0);
        bitset.flip();
        bitset.one();
        bitset.unfix(0);
        bitset.count();
        bitset.toString();
    }

    public int[] sortEvenOdd(int[] nums) {
        int size = nums.length;
        int[] nums0 = new int[size % 2 == 0 ? size / 2 : size / 2 + 1];
        int[] nums1 = new int[size / 2];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                nums0[i / 2] = nums[i];
            } else {
                nums1[i / 2] = nums[i];
            }
        }
        Arrays.sort(nums0);
        Arrays.sort(nums1);
        int[] results = new int[size];
        for (int i = 0; i < size / 2; i++) {
            results[i * 2] = nums0[i];
            results[i * 2 + 1] = nums1[size / 2 - 1 - i];
        }
        if (size % 2 == 1) {
            results[size - 1] = nums0[size / 2];
        }
        return results;
    }

    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean is = num >= 0;
        if (num < 0) {
            num = -num;
        }
        char[] chs = ("" + num).toCharArray();
        Arrays.sort(chs);
        StringBuilder str = new StringBuilder();
        if (is) {
            int count = 0;
            for (char ch : chs) {
                if ("".equals(str.toString()) && ch == '0') {
                    count++;
                } else {
                    str.append(ch);
                    if (count > 0) {
                        for (int j = 0; j < count; j++) {
                            str.append("0");
                        }
                        count = 0;
                    }
                }
            }
        } else {
            str.append("-");
            for (int i = chs.length - 1; i >= 0; i--) {
                str.append(chs[i]);
            }
        }
        return Long.parseLong(str.toString());
    }

    static class Bitset {

        int[] nums;
        int cnt;
        int is;

        public Bitset(int size) {
            nums = new int[size];
            cnt = 0;
            is = 0;
        }

        public void fix(int idx) {
            if (nums[idx] == is) {
                cnt++;
                nums[idx] = 1 - is;
            }
        }

        public void unfix(int idx) {
            if (nums[idx] != is) {
                cnt--;
                nums[idx] = 1 - nums[idx];
            }
        }

        public void flip() {
            cnt = nums.length - cnt;
            is = 1 - is;
        }

        public boolean all() {
            return cnt == nums.length;
        }

        public boolean one() {
            return cnt != 0;
        }

        public int count() {
            return cnt;
        }

        public String toString() {
            StringBuilder str = new StringBuilder();
            for (int num : nums) {
                if (is == 0) {
                    str.append(num);
                } else {
                    str.append(1 - num);
                }
            }
            return str.toString();
        }
    }

    public int minimumTime(String s) {
        int n = s.length();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (s.charAt(i - 1) == '0') {
                left[i] = left[i - 1];
            } else {
                left[i] = Math.min(i, left[i - 1] + 2);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                right[i] = right[i + 1];
            } else {
                right[i] = Math.min(n - i, right[i + 1] + 2);
            }
        }
        int times = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            times = Math.min(times, left[i] + right[i]);
        }
        return times;
    }
}
