package contest.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Week355 {

    public static void main(String[] args) {
        Week355 so = new Week355();
//        List<String> words = Arrays.asList("one.two.three","four.five","six");
//        char separator = '.';
//        System.out.println(so.splitWordsBySeparator(words,separator));
        List<Integer> usageLimits = Arrays.asList(2, 2, 2);
        System.out.println(so.maxIncreasingGroups(usageLimits));
    }

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int size = usageLimits.size();
        int left = 1;
        int right = size;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cnt = 0;
            for (int i = 1; i <= size; i++) {
                cnt += Math.max(0, mid - i);
                cnt -= Math.min(cnt, usageLimits.get(size - i - 1));
            }
            if (cnt == 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long maxArrayValue(int[] nums) {
        long max = nums[nums.length - 1];
        long cur = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= cur) {
                cur += nums[i];
            } else {
                max = Math.max(max, cur);
                cur = nums[i];
            }
        }
        return Math.max(max, cur);
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            String[] strs = word.split("\\" + separator);
            for (String str : strs) {
                if (str.length() > 0) {
                    list.add(str);
                }
            }
        }
        return list;
    }
}
