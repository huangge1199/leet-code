package contest.y2022.m9;

import java.util.*;

public class Week312 {
    public static void main(String[] args) {
        Week312 solution = new Week312();
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            List<Integer> temp = map.get(edge[0]);
            temp.add(edge[1]);
            map.put(edge[0], temp);
            temp = map.get(edge[1]);
            temp.add(edge[0]);
            map.put(edge[1], temp);
        }
        boolean[] uses = new boolean[vals.length];
        uses[0] = true;
        dfs(0, map, vals, uses, vals[0]);
        return cnt;
    }

    int cnt = 0;

    private void dfs(int index, Map<Integer, List<Integer>> map, int[] vals, boolean[] uses, int max) {
        if (index != max && vals[index] == vals[max]) {
            cnt++;
        }
        List<Integer> list = map.get(index);
        if (list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (uses[i] || vals[i] > vals[max]) {
                continue;
            }
            uses[i] = true;
            dfs(i,map,vals,uses,max);
        }
    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int size = nums.length;
        if (k * 2 >= size) {
            return res;
        }
        int[] left = new int[size];
        left[0] = 1;
        int[] right = new int[size];
        right[size - 1] = 1;
        for (int i = 1; i < size - k; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
            if (nums[size - 1 - i] <= nums[size - i]) {
                right[size - 1 - i] = right[size - i] + 1;
            } else {
                right[size - 1 - i] = 1;
            }
        }
        for (int i = k; i < size - k; i++) {
            if ((left[i] >= k + 1 || left[i - 1] >= k) && (right[i] >= k + 1 || right[i + 1] >= k)) {
                res.add(i);
            }
        }
        return res;
    }

    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == max) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        return Math.max(res, cnt);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        int index = heights.length - 1;
        for (int key : map.keySet()) {
            names[index] = map.get(key);
            index--;
        }
        return names;
    }
}
