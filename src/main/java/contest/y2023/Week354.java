package contest.y2023;

import java.lang.reflect.Array;
import java.util.*;

public class Week354 {
    public static void main(String[] args) {
        String word = "cbaaaabc";
        List<String> forbidden = Arrays.asList("aaa", "cb");
        System.out.println(longestValidSubstring(word, forbidden));
    }

    static List<String> strs = new ArrayList<>();

    public static int longestValidSubstring(String word, List<String> forbidden) {
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        forbidden.sort(lengthComparator);
        for (int i = 0; i < forbidden.size(); i++) {
            for (int j = i + 1; j < forbidden.size(); j++) {
                if(forbidden.get(j).contains(forbidden.get(i))){
                    forbidden.remove(forbidden.get(j));
                }
            }
        }

        int max = getMax(word, forbidden);
        strs.sort(lengthComparator);
        while (strs.size() > 0 && strs.get(strs.size() - 1).length() > max) {
            String str = strs.get(strs.size() - 1);
            strs.remove(str);
            max = Math.max(max, getMax(str, forbidden));
            strs.sort(lengthComparator);
        }
        return max;
    }

    private static int getMax(String word, List<String> forbidden) {
        for (String str : forbidden) {
            if (word.contains(str)) {
                int index = word.indexOf(str);
                if (!strs.contains(word.substring(0, index))) {
                    strs.add(word.substring(0, index));
                }
                if (!strs.contains(word.substring(index + 1))) {
                    strs.add(word.substring(index + 1));
                }
                String substring = word.substring(0, index + str.length() - 1);
                if (!strs.contains(substring)) {
                    strs.add(substring);
                }
                String substring1 = word.substring(index + str.length());
                if (!strs.contains(substring1)) {
                    strs.add(substring1);
                }
                return 0;
            }
        }
        return word.length();
    }

    public int minimumIndex(List<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        Arrays.sort(arr);
        int cnt = 1;
        int num = arr[0];
        int max = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                if (max < cnt) {
                    max = cnt;
                    num = arr[i - 1];
                }
                cnt = 1;
            }
        }
        if (max < cnt) {
            max = cnt;
            num = arr[nums.size() - 1];
        }
        if (cnt * 2 == nums.size() + 1) {
            return -1;
        }
        cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == num) {
                cnt++;
                if (cnt * 2 > i + 1 && (max - cnt) * 2 > nums.size() - i - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[index] > k * 2) {
                max = Math.max(max, i - index);
                index++;
            }
        }
        return Math.max(max, nums.length - index);
    }

    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (size % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
}
