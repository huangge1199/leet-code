package leet.book.contest.contest5;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.minimumSteps(new int[]{2, 5, 1, 2, 1, 1, 7}));
    }

    public int minimumSteps(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] use = new boolean[nums.length];
        use[0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                int step = nums[num];
                if (num + step >= nums.length - 1) {
                    return count;
                }
                if (step > 0) {
                    for (int j = 1; j <= step; j++) {
                        if (!use[num + j]) {
                            use[num + j] = true;
                            queue.add(num + j);
                        }
                    }
                } else {
                    for (int j = 1; j <= -step && j >= 0; j++) {
                        if (!use[num - j]) {
                            use[num - j] = true;
                            queue.add(num - j);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
