package contest.y2022.m5.week;


import java.util.*;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/15 10:29
 */
public class Solution293 {
    public static void main(String[] args) {
        Solution293 solution = new Solution293();
//        solution.maxConsecutive(6, 8, new int[]{7, 6, 8});
        CountIntervals ci = new CountIntervals();
        ci.add(2,3);
        ci.add(7,10);
        System.out.println(ci.cnt);
        ci.add(5,8);
        System.out.println(ci.cnt);
    }

    public List<String> removeAnagrams(String[] words) {
        char[] strs = words[0].toCharArray();
        Arrays.sort(strs);
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 1; i < words.length; i++) {
            char[] strs1 = words[i].toCharArray();
            Arrays.sort(strs1);
            if (!String.valueOf(strs).equals(String.valueOf(strs1))) {
                list.add(words[index]);
                strs = strs1;
                index = i;
            }
        }
        list.add(words[index]);
        return list;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = 0;
        for (int i = 0; i < special.length; i++) {
            if (special[i] < bottom) {
                continue;
            }
            if (special[i] > top) {
                if (i > 0) {
                    max = Math.max(max, top - special[i - 1]);
                }
                break;
            }
            if (bottom <= special[i]) {
                max = Math.max(max, special[i] - bottom);
                bottom = special[i] + 1;
            }
        }
        if (top > special[special.length - 1]) {
            max = Math.max(max, top - special[special.length - 1]);
        }
        return max;
    }

    public int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 0; i < 25; i++) {
            int cnt = 0;
            for (int j = 0; j < candidates.length; j++) {
                if ((candidates[j] & (1 << i)) > 0) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
