package contest.y2022.m3.week;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution285 {
    public static void main(String[] args) {
        Solution285 solution = new Solution285();
        solution.longestRepeating("babacc", "bcb", new int[]{1, 3, 3});
    }

    public int countHillValley(int[] nums) {
        int bef = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == bef || nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] > bef && nums[i] > nums[i + 1]) {
                count++;
            }
            if (nums[i] < bef && nums[i] < nums[i + 1]) {
                count++;
            }
            bef = nums[i];
        }
        return count;
    }

    public int countCollisions(String directions) {
        int count = 0;
        while (directions.startsWith("L")) {
            directions = directions.substring(1);
        }
        while (directions.endsWith("R")) {
            directions = directions.substring(0, directions.length() - 1);
        }
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'R') {
                if (i + 1 < directions.length() && directions.charAt(i) == directions.charAt(i + 1)) {
                    count++;
                } else if (i + 1 < directions.length() && directions.charAt(i + 1) == 'L') {
                    count += 2;
                    i++;
                } else {
                    count++;
                    i++;
                }
            } else if (directions.charAt(i) == 'L') {
                count++;
            }
        }
        return count;
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(numArrows, aliceArrows, 11, 0, new int[12]);
        return res;
    }

    int max = 0;
    int[] res;

    private void dfs(int numArrows, int[] aliceArrows, int index, int score, int[] resut) {
        if (index < 0 || numArrows == 0) {
            if (score > max) {
                max = score;
                res = resut;
            }
            return;
        }
        if (index == 0) {
            resut[0] = numArrows;
            dfs(0, aliceArrows, index - 1, score, resut);
            return;
        }
        int[] temp = Arrays.copyOf(resut, resut.length);
        dfs(numArrows, aliceArrows, index - 1, score, temp);
        if (numArrows > aliceArrows[index]) {
            temp = Arrays.copyOf(resut, resut.length);
            temp[index] = aliceArrows[index] + 1;
            dfs(numArrows - aliceArrows[index] - 1, aliceArrows, index - 1, score + index, temp);
        }
    }


    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int size = queryIndices.length;
        int[] res = new int[size];
        List<int[]> list = gettList(s);
        int max = list.get(0)[1];

        for (int i = 0; i < size; i++) {
            if (s.charAt(queryIndices[i]) == queryCharacters.charAt(i) || queryIndices[i] < list.get(0)[0] || queryIndices[i] >= list.get(0)[0] + list.get(0)[1]) {
                res[i] = max;
                s = s.substring(0, queryIndices[i]) + queryCharacters.charAt(i) + s.substring(queryIndices[i] + 1);
                continue;
            }
            s = s.substring(0, queryIndices[i]) + queryCharacters.charAt(i) + s.substring(queryIndices[i] + 1);
            list = gettList(s);
            max = list.get(0)[1];
            res[i] = max;
        }
        return res;
    }

    private List<int[]> gettList(String s) {
        List<int[]> list = new ArrayList<>();
        int bef = 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(new int[]{bef, count});
                bef = i;
                count = 1;
            }
        }
        list.add(new int[]{bef, count});
        Collections.sort(list, (o1, o2) -> o2[1] - o1[1]);
        return list;
    }
}
