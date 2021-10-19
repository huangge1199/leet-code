package contest.y2021.m05.week;

import java.util.*;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/5/16 11:03
 * @Description:
 */
class FindSumPairs {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) - 1);
        map.put(nums2[index] + val, map.getOrDefault(nums2[index] + val, 0) + 1);
        nums2[index] += val;
    }

    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            count += map.getOrDefault(tot - nums1[i], 0);
        }
        return count;
    }
}
