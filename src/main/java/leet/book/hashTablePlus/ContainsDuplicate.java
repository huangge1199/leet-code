package leet.book.hashTablePlus;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return false;
                }
                set.add(num);
            }
            return true;
        }
    }
}
