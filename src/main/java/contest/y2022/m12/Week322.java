package contest.y2022.m12;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.*;

public class Week322 {
    public static void main(String[] args) {
        Week322 solution = new Week322();
        //System.out.println(solution.isCircularSentence("leetcode exercises sound delightful"));
        TwoArray twoArray = new TwoArray("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]", true);
        System.out.println(solution.minScore(4, twoArray.getArr()));
    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            List<Pair<Integer, Integer>> list = map.get(road[0]);
            list.add(new Pair<>(road[1], road[2]));
            map.put(road[0], list);
            list = map.get(road[1]);
            list.add(new Pair<>(road[0], road[2]));
            map.put(road[1], list);
        }
        int min = Integer.MAX_VALUE;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] use = new boolean[n + 1];
        use[1] = true;
        for (Pair<Integer, Integer> pair : map.get(1)) {
            queue.add(pair);
        }
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            min = Math.min(min, pair.getValue());
            if (!use[pair.getKey()]) {
                queue.addAll(map.get(pair.getKey()));
                queue.add(pair);
                use[pair.getKey()] = true;
            }
        }
        return min;
    }

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int sum = skill[0] + skill[skill.length - 1];
        long res = (long) skill[0] * skill[skill.length - 1];
        for (int i = 1; i < skill.length / 2; i++) {
            int tmp = skill[i] + skill[skill.length - 1 - i];
            if (sum != tmp) {
                return -1;
            }
            res += (long) skill[i] * skill[skill.length - 1 - i];
        }
        return res;
    }

    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        if (strs[0].charAt(0) != strs[strs.length - 1].charAt(strs[strs.length - 1].length() - 1)) {
            return false;
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i - 1].charAt(strs[i - 1].length() - 1) != strs[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
