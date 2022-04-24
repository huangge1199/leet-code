package contest.y2022.m4.week;

import com.code.leet.entiy.TwoArray;
import javafx.util.Pair;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/17 10:29
 */
public class Solution290 {

    public static void main(String[] args) {
        Solution290 solution = new Solution290();
        TwoArray circles = new TwoArray("[[2,2,1]]", true);
        solution.countLatticePoints(circles.getArr());
    }

    public List<Integer> intersection(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] temps : nums) {
            Arrays.sort(temps);
            for (int j = 0; j < temps.length; j++) {
                if (j == 0) {
                    map.put(temps[j], map.getOrDefault(temps[j], 0) + 1);
                } else {
                    map.put(temps[j], map.getOrDefault(temps[j], 0) + 1);

                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == nums.length) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }

    public int countLatticePoints(int[][] circles) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        for (int[] circle : circles) {
            for (int i = circle[0] - circle[2]; i <= circle[0] + circle[2]; i++) {
                for (int j = circle[1] - circle[2]; j <= circle[1] + circle[2]; j++) {
                    if (((i - circle[0]) * (i - circle[0]) + (j - circle[1]) * (j - circle[1]) <= circle[2] * circle[2])) {
                        set.add(new Pair<>(i, j));
                    }
                }
            }
        }
        return set.size();
    }

    //public int[] countRectangles(int[][] rectangles, int[][] points) {
    //
    //}

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int max = flowers[0][1];
        for (int[] f : flowers) {
            max = Math.max(max, f[1]);
        }

        int[] arrs = new int[max];
        for (int f[] : flowers) {
            arrs[f[0]] -= f[0];
            arrs[f[1]] += f[1];
        }
        int flag = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] == 0) {
                continue;
            }
            flag = i;
            for (int j = 0; j < i; j++) {
                arrs[j] = arrs[i];
            }
            break;
        }
        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] <= flag) {
                res[i] = arrs[i];
                continue;
            }
            for (int j = flag + 1; j <= persons[i]; j++) {
                arrs[j] += arrs[j - 1];
            }
            res[i] = arrs[i];
            flag = persons[i];
        }
        return res;
    }
}
