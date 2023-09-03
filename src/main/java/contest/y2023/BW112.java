package contest.y2023;

import java.util.*;

public class BW112 {
    public static void main(String[] args) {
        BW112 so = new BW112();
//        String s1 = "abe";
//        String s2 = "bea";
//        so.checkStrings(s1, s2);
        List<Integer> nums = Arrays.asList(2, 6, 7, 3, 1, 7);
        int m = 3;
        int k = 4;
        so.maxSum(nums, m, k);
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        long max = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            set.add(nums.get(i));
            list.add(nums.get(i));
            if (i < k - 1) {
                continue;
            } else if (i == k - 1) {
                if (set.size() >= m) {
                    max = Math.max(max, sum);
                }
            } else {
                list.remove(nums.get(i - k));
                if (!list.contains(nums.get(i - k))) {
                    set.remove(nums.get(i - k));
                }
                sum -= nums.get(i - k);
                if (set.size() >= m) {
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public boolean checkStrings(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int size = s1.length();
        char[] ch10 = new char[size / 2 + (size % 2)];
        char[] ch20 = new char[size / 2 + (size % 2)];
        char[] ch11 = new char[size / 2];
        char[] ch21 = new char[size / 2];
        for (int i = 0; i < size / 2 + (size % 2); i++) {
            ch10[i] = ch1[i * 2];
            ch20[i] = ch2[i * 2];
            if (i < size / 2) {
                ch11[i] = ch1[i * 2 + 1];
                ch21[i] = ch2[i * 2 + 1];
            }
        }
        Arrays.sort(ch10);
        Arrays.sort(ch11);
        Arrays.sort(ch20);
        Arrays.sort(ch21);
        for (int i = 0; i < size / 2 + (size % 2); i++) {
            if (ch10[i] != ch20[i]) {
                return false;
            }
            if (i < size / 2) {
                if (ch11[i] != ch21[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canBeEqual(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for (int i = 0; i < 4; i++) {
            if (ch1[i] != ch2[i]) {
                if (i > 1) {
                    return false;
                } else {
                    if (ch1[i + 2] != ch2[i]) {
                        return false;
                    }
                    ch1[i + 2] = ch1[i];
                }
            }
        }
        return true;
    }
}
