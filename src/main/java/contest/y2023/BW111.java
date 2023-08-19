package contest.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BW111 {
    public static void main(String[] args) {
        BW111 so = new BW111();
        List<Integer> nums = Arrays.asList(2, 1, 3, 2, 1);
        so.minimumOperations(nums);
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int cnt = 0;
        List<Integer> list = Arrays.asList(10, 1001, 100011, 10000111);
        if (low <= 10 && high >= 10) {
            int num = 10;
            int add = k % 2 == 0 ? k : 2 * k;
            while (num % k != 0 && num <= high) {
                num += 2;
            }
            if (num > high) {
                return cnt;
            }
            cnt += (Math.min(99, high) - num) / add + 1;
        }
        if (low <= 1001 && high >= 1001) {
            int num = 1001;
            int add = k % 2 == 0 ? k : 2 * k;
            while (num % k != 0 && num <= high) {
                num += 2;
            }
            if (num > high) {
                return cnt;
            }
            cnt += (Math.min(9999, high) - num) / add + 1;
        }
        if (low <= 100011 && high >= 100011) {
            int num = 100011;
            int add = k % 2 == 0 ? k : 2 * k;
            while (num % k != 0 && num <= high) {
                num += 2;
            }
            if (num > high) {
                return cnt;
            }
            cnt += (Math.min(999999, high) - num) / add + 1;
        }
        if (low <= 10000111 && high >= 10000111) {
            int num = 10000111;
            int add = k % 2 == 0 ? k : 2 * k;
            while (num % k != 0 && num <= high) {
                num += 2;
            }
            if (num > high) {
                return cnt;
            }
            cnt += (Math.min(99999999, high) - num) / add + 1;
        }
        return cnt;
    }

    public int minimumOperations(List<Integer> nums) {
        int x = 0, y = 0, z = 0;
        for (int num : nums) {
            if (num == 1) {
                y++;
                z++;
            } else if (num == 2) {
                z++;
                y = Math.min(x, y);
                x++;
            } else {
                z = Math.min(x, Math.min(y, z));
                x++;
                y++;
            }
        }
        return Math.min(x, Math.min(y, z));
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }
        int index = 0;
        for (char ch : str1.toCharArray()) {
            if (index == str2.length()) {
                break;
            }
            if (ch == str2.charAt(index) || (ch == 'z' ? 'a' : ch + 1) == str2.charAt(index)) {
                index++;
            }
        }
        return index == str2.length();
    }

    public int countPairs(List<Integer> nums, int target) {
        int cnt = 0;
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}
