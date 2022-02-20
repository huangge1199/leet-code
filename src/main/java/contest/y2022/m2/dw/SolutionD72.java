package contest.y2022.m2.dw;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/2/19 22:28
 */
public class SolutionD72 {
    public static void main(String[] args) {
        SolutionD72 solutionD72 = new SolutionD72();
    }

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if ((i * j) % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        return new long[]{num / 3 - 1, num / 3, num / 3 + 1};
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) {
            return new ArrayList<>();
        }
        long num = 2;
        List<Long> list = new ArrayList<>();
        while (finalSum >= num) {
            list.add(num);
            finalSum -= num;
            num += 2;
        }
        long temp = list.get(list.size() - 1);
        temp += finalSum;
        list.set(list.size() - 1, temp);
        return list;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int size = nums1.length;
        long count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k = j + 1; k < size; k++) {
                        for (int l = i + 1; l < size; l++) {
                            if (nums1[l] == nums2[k]) {
                                for (int m = l + 1; m < size; m++) {
                                    for (int n = k + 1; n < size; n++) {
                                        if (nums2[n] == nums1[m]) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
