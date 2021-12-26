package contest.y2021.m12.week;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution273 {
    public static void main(String[] args) {
        Solution273 solution = new Solution273();
//        solution.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
        solution.recoverArray(new int[]{11, 6, 3, 4, 8, 7, 8, 7, 9, 8, 9, 10, 10, 2, 1, 9});
    }

    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 > 0;
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] arrs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = startPos[0];
            int y = startPos[1];
            String str = s.substring(i);
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'R') {
                    y++;
                    if (y >= n) {
                        break;
                    }
                } else if (ch == 'L') {
                    y--;
                    if (y < 0) {
                        break;
                    }
                } else if (ch == 'U') {
                    x--;
                    if (x < 0) {
                        break;
                    }
                } else {
                    x++;
                    if (x >= n) {
                        break;
                    }
                }
                arrs[i]++;
            }
        }
        return arrs;
    }

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        long[] arrs = new long[arr.length];
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == 1) {
                arrs[list.get(0)] = 0;
            } else {
                long[] temp = new long[list.size() + 1];
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    temp[i + 1] = temp[i] + list.get(i);
                }
                for (int i = 0; i < list.size(); i++) {
                    arrs[list.get(i)] = temp[temp.length - 1] - temp[i + 1] - temp[i] - ((long) temp.length - 2 * i - 2) * list.get(i);
                }
            }
        }
        return arrs;
    }

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1, result[] = new int[nums.length / 2]; ; i++) {
            if (nums[i] > nums[0] && (nums[i] - nums[0]) % 2 == 0) {
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                for (int j = 0, k = 0; j < nums.length; j++) {
                    if (!deque.isEmpty() && deque.peek() == nums[j]) {
                        deque.poll();
                    } else if (k == result.length) {
                        break;
                    } else {
                        deque.offer(nums[j] + nums[i] - nums[0]);
                        result[k++] = nums[j] + (nums[i] - nums[0]) / 2;
                    }
                }
                if (deque.isEmpty()) {
                    return result;
                }
            }
        }
    }
}
}
