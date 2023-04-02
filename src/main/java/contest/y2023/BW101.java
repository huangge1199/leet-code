package contest.y2023;

import java.util.*;

public class BW101 {
    public static void main(String[] args) {
        BW101 solution = new BW101();
        solution.maximumCostSubstring("adaa", "d", new int[]{-1000});
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] score = new int[26];
        for (int i = 0; i < 26; i++) {
            score[i] = i + 1;
        }
        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            score[ch - 'a'] = vals[i];
        }
        int bef = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            bef = Math.max(bef + score[ch - 'a'], score[ch - 'a']);
            max = Math.max(max, bef);
        }
        return max;
    }

    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                return nums1[i1];
            }
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        if (nums1[0] < nums2[0]) {
            return nums1[0] * 10 + nums2[0];
        } else {
            return nums2[0] * 10 + nums1[0];
        }
    }
}
