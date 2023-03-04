package contest.y2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week333 {
    public static void main(String[] args) {
        Week333 solution = new Week333();
        System.out.println(solution.squareFreeSubsets(new int[]{26, 6, 4, 27, 6, 18}));
    }

    public int squareFreeSubsets(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arrs = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int arr : arrs) {
            map.put(arr, new ArrayList<>());
        }
        int count = 0;
        for (int num : nums) {
            if (num % 4 == 0 || num % 9 == 0 || num % 16 == 0) {
                continue;
            }
            count++;
            for (int arr : arrs) {
                if (num % arr == 0) {
                    List<Integer> list = map.get(arr);
                    list.add(num);
                    map.put(arr, list);
                }
            }
        }
        return 0;
    }

    public int minOperations(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            int num = (int) Math.sqrt(n);
            if (n == Math.pow(num, 2)) {
                break;
            }
            n = (int) Math.min((n - Math.pow(2, num)), (Math.pow(2, num + 1) - n));
        }
        return count;
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] arr = new int[1000];
        for (int[] nums : nums1) {
            arr[nums[0] - 1] += nums[1];
        }
        for (int[] nums : nums2) {
            arr[nums[0] - 1] += nums[1];
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(new int[]{i + 1, arr[i]});
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
