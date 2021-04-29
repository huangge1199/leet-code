package com.code.leet.Official.t20210205;

public class DrawLine {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        int low = (y * w + x1) / 32;
        int high = (y * w + x2) / 32;
        for (int i = low; i <= high; i++) {
            ans[i] = -1;
        }
        ans[low] = ans[low] >>> x1 % 32;
        ans[high] = ans[high] & Integer.MIN_VALUE >> x2 % 32;
        return ans;
    }
}
