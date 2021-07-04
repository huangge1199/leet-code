package leet.book.hashTablePlus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            int index = 0;
            for (int num : nums2) {
                if (set.contains(num)) {
                    set.remove(num);
                    nums1[index] = num;
                    index++;
                }
            }
            return Arrays.copyOf(nums1, index);
        }
    }
}
