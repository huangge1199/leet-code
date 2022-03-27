package contest.y2022.m3.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution286 {
    public static void main(String[] args) {
        Solution286 solution = new Solution286();
//        int[] arrs = new int[40000];
//        Arrays.fill(arrs, 100000);
//        solution.minDeletion(arrs);
//        System.out.println(solution.minDeletion(new int[]{0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5}));
        long[] arrs=solution.kthPalindrome(new int[]{1,2,3,4,5,90},3);
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        for (int num : list1) {
            if (!list2.contains(num) && !list.get(0).contains(num)) {
                list.get(0).add(num);
            }
        }
        for (int num : list2) {
            if (!list1.contains(num) && !list.get(1).contains(num)) {
                list.get(1).add(num);
            }
        }
        return list;
    }

    public int minDeletion(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        list.add(nums[1]);
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != list.get(index - 1) || nums[i] != list.get(index - 2)) {
                list.add(0, nums[i]);
                index++;
            }
        }
        if (list.size() < 2) {
            return nums.length;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0 && i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
            }
        }
        int sub = list.size() % 2 == 0 ? list.size() : list.size() - 1;
        return nums.length - sub;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long x = 10 * ((intLength + 1) / 2 - 1);
        long[] arrs = new long[queries.length];
        int index = 0;
        for (int query : queries) {
            long tmp = x + query - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(tmp);
            String str;
            if (intLength % 2 == 0) {
                str = sb.toString() + sb.reverse();
            } else {
                str = sb + sb.reverse().substring(1);
            }
            if (str.length() != intLength) {
                arrs[index] = -1;
            } else {
                arrs[index] = Long.parseLong(str);
            }
            index++;
        }
        return arrs;
    }
}
