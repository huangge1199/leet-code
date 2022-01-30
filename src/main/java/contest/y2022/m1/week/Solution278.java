package contest.y2022.m1.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution278 {
    public static void main(String[] args) {
        Solution278 solution = new Solution278();
        solution.maxScoreIndices(new int[]{0, 0, 1, 0});
    }

    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (original == num) {
                original = num * 2;
            }
        }
        return original;
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int size = nums.length;
        int[] count0 = new int[size + 1];
        int[] count1 = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            if (i < size) {
                count0[i + 1] = count0[i];
                if (nums[i] == 0) {
                    count0[i + 1]++;
                }
            }
            if (i > 0) {
                count1[size - i] = count1[size - i + 1];
                if (nums[size - i] == 1) {
                    count1[size - i]++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size + 1; i++) {
            if (max < count0[i] + count1[i]) {
                max = count0[i] + count1[i];
                list = new ArrayList<>();
                list.add(i);
            } else if (max == count0[i] + count1[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int size = s.length();
        int[] km = new int[size];
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                km[0] = 1;
            } else if (i == 1) {
                km[i] = power % modulo;
            } else {
                km[i] = (km[i - 1] * (power % modulo)) % modulo;
            }
        }
        char[] chs = s.toCharArray();
        int[] ss = new int[size];
        for (int i = 0; i < size; i++) {
            ss[i] = chs[i] - 'a' + 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int temp = ((ss[i] % modulo) * km[i]) % modulo;
            queue.add(temp);
            sum += temp;
        }
        if (sum == hashValue) {
            return s.substring(0, k);
        }
        for (int i = 1; i < size; i++) {

        }
        return null;
    }
}

}
