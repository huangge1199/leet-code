package contest.y2021.m04.week;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/4 10:33
 * @Description:
 */
public class Solution235 {
    public String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return s;
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sBuilder.append(strings[i]).append(" ");
        }
        s = sBuilder.toString();
        s = s.substring(0, s.length() - 1);
        return s;
    }

    public static void main(String[] args) {
        Solution235 solution235 = new Solution235();

        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        solution235.findingUsersActiveMinutes(logs, k);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < logs.length; i++) {
            List<Integer> temp;
            min = Math.min(min, logs[i][0]);
            if (map.containsKey(logs[i][0])) {
                temp = map.get(logs[i][0]);
                if (!temp.contains(logs[i][1])) {
                    temp.add(logs[i][1]);
                }
                map.put(logs[i][0], temp);
            } else {
                temp = new ArrayList<>();
                temp.add(logs[i][1]);
                map.put(logs[i][0], temp);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = 0;
        }
        for (int key : map.keySet()) {
            int index = map.get(key).size();
            result[index - 1] = result[index - 1] + 1;
        }
        return result;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long result = 0;
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> tempStack = new Stack<>();
        int size = nums1.length;
        for (int i = 0; i < size; i++) {
            int temp = Math.abs(nums1[i] - nums2[i]);
            result += temp;
            if (!tempStack.isEmpty()) {
                while (temp > tempStack.peek()[1]) {
                    stack.push(tempStack.pop());
                }
            }
            while (temp < stack.peek()[1]) {
                tempStack.push(stack.pop());
            }
            stack.push(new int[]{i, temp});
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        int max = -1;
        while (!stack.isEmpty()) {
            int[] arr = stack.pop();
            int i;
            for (i = 0; i < arr[1]; i++) {
                if (set.contains(nums2[arr[0]] - i) || set.contains(nums2[arr[0]] + i)) {
                    break;
                }
            }
            if(nums2[arr[0]] - i>stack.peek()[1]){
                break;
            }
        }

        return (int) ((result - max) % (Math.pow(10, 9) + 7));
    }
}
