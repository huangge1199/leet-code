package contest.y2022.m5.week;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/5/1 10:35
 */
public class Solution291 {
    public static void main(String[] args) {
        Solution291 solution = new Solution291();
//        solution.removeDigit("123", '3');
        solution.minimumCardPickup(new int[]{77, 10, 11, 51, 69, 83, 33, 94, 0, 42, 86, 41, 65, 40, 72, 8, 53, 31, 43, 22, 9, 94, 45, 80, 40, 0, 84, 34, 76, 28, 7, 79, 80, 93, 20, 82, 36, 74, 82, 89, 74, 77, 27, 54, 44, 93, 98, 44, 39, 74, 36, 9, 22, 57, 70, 98, 19, 68, 33, 68, 49, 86, 20, 50, 43});
    }

    public String removeDigit(String number, char digit) {
        int index = number.indexOf(digit);
        String temp = number;
        while (index + 1 < number.length() && number.charAt(index + 1) <= number.charAt(index)) {
            temp = number.substring(index + 1);
            int in = temp.indexOf(digit);
            if (in >= 0) {
                index += 1 + in;
            } else {
                break;
            }
        }
        return number.substring(0, index) + number.substring(index + 1);
    }

    public int minimumCardPickup(int[] cards) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            set.add(cards[i]);
            List<Integer> list = map.getOrDefault(cards[i], new ArrayList<>());
            list.add(i);
            map.put(cards[i], list);
        }
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i) - list.get(i - 1) + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            String str = "";
            int count = 0;
            for (int j = i; j < size; j++) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                str += nums[j] + ",";
                set.add(str);
            }
        }
        return set.size();
    }

    public long appealSum(String s) {
        int size = s.length();
        long count = 0;
        long result = 0;
        long now = 0;
        long[] arrs = new long[26];
        for (int i = size - 1; i >= 0; i--) {
            count += 1;
            now += count;
            if (arrs[s.charAt(i) - 'a'] > 0) {
                now -= arrs[s.charAt(i) - 'a'];
            }
            arrs[s.charAt(i) - 'a'] = count;
            result += now;
        }
        return result;
    }
}
