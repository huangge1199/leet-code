package contest.y2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week356 {

    public static void main(String[] args) {
        Week356 so = new Week356();
        String a = "ab", b = "a", c = "c";
        so.minimumString(a, b, c);
    }

    public String minimumString(String a, String b, String c) {
        String str = getStr(getStr(a, b), c);
        List<String> list = new ArrayList<>();
        list.add(getStr(a, getStr(b, c)));
        list.add(getStr(getStr(a, c), b));
        list.add(getStr(a, getStr(c, b)));
        list.add(getStr(getStr(b, a), c));
        list.add(getStr(b, getStr(a, c)));
        list.add(getStr(getStr(b, c), a));
        list.add(getStr(b, getStr(c, a)));
        list.add(getStr(getStr(c, a), b));
        list.add(getStr(c, getStr(a, b)));
        list.add(getStr(getStr(c, b), a));
        list.add(getStr(c, getStr(b, a)));
        for (String tmp : list) {
            tmp = getStr(a, getStr(b, c));
            if (str.length() < tmp.length() || (str.length() == tmp.length() && isBef(tmp, str))) {
                str = tmp;
            }
        }
        return str;
    }

    private boolean isBef(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] < ch2[i]) {
                return true;
            } else if (ch1[i] > ch2[i]) {
                return false;
            }
        }
        return true;
    }

    private String getStr(String str1, String str2) {
        if (str1.contains(str2)) {
            return str1;
        }
        for (int i = str2.length(); i >= 1; i--) {
            if (str1.endsWith(str2.substring(0, i))) {
                return str1 + str2.substring(i);
            }
        }
        return str1 + str2;
    }

    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            map = new HashMap<>();
            map.put(nums[i], 1);
            if (cnt == size) {
                res++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    map.put(nums[j], map.get(nums[j]) + 1);
                } else {
                    map.put(nums[j], 1);
                    cnt++;
                }
                if (cnt == size) {
                    res += nums.length - j;
                    break;
                }
                if (cnt + nums.length - 1 - j < size) {
                    break;
                }
            }
            if (nums.length - 1 - i < size) {
                break;
            }
        }
        return res;
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for (int hour : hours) {
            if (hour >= target) {
                cnt++;
            }
        }
        return cnt;
    }
}
