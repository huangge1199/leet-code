package contest.y2022.m9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyy
 * @Classname Week309
 * @Description TODO
 * @Date 2022/9/4 10:28
 */
public class Week309 {
    public static void main(String[] args) {
        Week309 solution = new Week309();
        solution.numberOfWays(989, 1000, 99);
    }

    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int num = 0;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            while (left < i && (num & nums[i]) > 0) {
                num -= nums[left];
                left += 1;
            }
            num |= nums[i];
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        int num = k - Math.abs(endPos - startPos);
        if (num < 0 || num % 2 == 1) {
            return 0;
        }
        if (num == 0) {
            return 1;
        }
        long ret = 0;
        if (map.containsKey(endPos - 1)) {
            Map<Integer, Integer> tmp = map.get(endPos - 1);
            if (tmp.containsKey(k - 1)) {
                ret += tmp.get(k - 1);
            } else {
                ret += numberOfWays(startPos, endPos - 1, k - 1);
            }
        } else {
            ret += numberOfWays(startPos, endPos - 1, k - 1);
        }
        if (map.containsKey(endPos + 1)) {
            Map<Integer, Integer> tmp = map.get(endPos + 1);
            if (tmp.containsKey(k - 1)) {
                ret += tmp.get(k - 1);
            } else {
                ret += numberOfWays(startPos, endPos + 1, k - 1);
            }
        } else {
            ret += numberOfWays(startPos, endPos + 1, k - 1);
        }
        Map<Integer, Integer> tmp = map.getOrDefault(endPos, new HashMap<>());
        tmp.put(k, (int) ret);
        map.put(endPos, tmp);
        return map.get(endPos).get(k);
    }

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public boolean checkDistances(String s, int[] distance) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (arr[index] > -1) {
                if (distance[index] != i - arr[index] - 1) {
                    return false;
                }
            } else {
                arr[index] = i;
            }
        }
        return true;
    }
}
