package contest.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BW98 {
    public static void main(String[] args) {
        BW98 solution = new BW98();
        System.out.println(solution.minMaxDifference(456));
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        long sum = Arrays.stream(nums2).sum();
        List<Long> list = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; i++) {
                    nums1[i] = 1 - nums1[i];
                }
            } else if (query[0] == 2) {
                sum += (long) query[1] * Arrays.stream(nums1).sum();
            } else {
                list.add(sum);
            }
        }
        long[] res = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int minImpossibleOR(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int num = 1;
        while (list.contains(num)) {
            num *= 2;
        }
        return num;
    }

    public int minimizeSum(int[] nums) {
        if (nums.length == 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[nums.length - 3] - nums[0];
        min = Math.min(min, nums[nums.length - 2] - nums[1]);
        min = Math.min(min, nums[nums.length - 1] - nums[2]);
        return min;
    }

    public int minMaxDifference(int num) {
        String str = "" + num;
        String max = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                max = str.replace(str.substring(i, i + 1), "9");
                break;
            }
        }
        if (max.equals("")) {
            max = str;
        }
        String min = str.replace(str.substring(0, 1), "0");
        while (min.startsWith("0")) {
            min = min.substring(1);
        }
        if (min.equals("")) {
            min = "0";
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
