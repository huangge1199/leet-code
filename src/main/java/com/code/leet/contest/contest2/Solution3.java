package com.code.leet.contest.contest2;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.previousPermutation(new int[]{3, 0, 4, 2, 1});
    }

    public int[] previousPermutation(int[] permutation) {
        List<Integer> list = new ArrayList<>();
        int i = permutation.length - 2;
        list.add(permutation[permutation.length - 1]);
        for (; i >= 0; i--) {
            list.add(permutation[i]);
            if (permutation[i] > permutation[i + 1]) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) < permutation[i]) {
                        int temp = list.get(j);
                        list.set(j, permutation[i]);
                        permutation[i] = temp;
                        break;
                    }
                }
                break;
            }
        }
        if (i == -1) {
            for (int j = 0; j < permutation.length; j++) {
                permutation[j] = list.get(j);
            }
        } else {
            for (int j = 0; j < permutation.length - 1 - i; j++) {
                permutation[i + j + 1] = list.get(j);
            }
        }
        return permutation;
    }
}
