package contest.y2022.season;

import com.code.leet.entiy.TreeNode;
import com.code.leet.entiy.TwoArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/4/16 15:02
 */
public class SolutionSpring {
    public static void main(String[] args) {
        SolutionSpring solution = new SolutionSpring();

//        int[] materials = new int[]{3, 2, 4, 1, 2};
//        TwoArray cookbooks = new TwoArray("[[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]", true);
//        TwoArray attribute = new TwoArray("[[3,2],[2,4],[7,6]]", true);
//        System.out.println(solution.perfectMenu(materials, cookbooks.getArr(), attribute.getArr(), 5));

        //5
//        TwoArray roads = new TwoArray("[[0,1],[0,2],[1,3],[2,3],[1,2],[2,4],[2,5]]",true);
//        int[] cost = new int[]{1,2,3,4,5,6};
//        TwoArray roads = new TwoArray("[[0,2],[2,3],[3,1]]", true);
//        int[] cost = new int[]{3, 2, 1, 4};
//        System.out.println(solution.minimumCost(cost, roads.getArr()));
    }

//    public int giveGem(int[] gem, int[][] operations) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int[] operation : operations) {
//            int num = gem[operation[0]] / 2;
//            gem[operation[0]] -= num;
//            gem[operation[1]] += num;
//        }
//        for (int j : gem) {
//            min = Math.min(min, j);
//            max = Math.max(max, j);
//        }
//        return max - min;
//    }
//
//    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
//        dfs(materials, cookbooks, attribute, limit, 0, 0, 0);
//        return max;
//    }
//    int max = -1;
//    private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int index, int x, int y) {
//        if (index == cookbooks.length) {
//            if (y >= limit) {
//                max = Math.max(max, x);
//            }
//            return;
//        }
//        dfs(materials, cookbooks, attribute, limit, index + 1, x, y);
//        int[] newMater = materials.clone();
//        for (int i = 0; i < 5; i++) {
//            if (newMater[i] < cookbooks[index][i]) {
//                return;
//            }
//            newMater[i] -= cookbooks[index][i];
//        }
//        dfs(newMater, cookbooks, attribute, limit, index + 1, x + attribute[index][0], y + attribute[index][1]);
//    }

    //    // 第五题（错误）
//    public long minimumCost(int[] cost, int[][] roads) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        long sum = 0;
//        for (int i = 0; i < cost.length; i++) {
//            map.put(i, new ArrayList<>());
//            sum += cost[i];
//        }
//        for (int[] road : roads) {
//            List<Integer> list = map.get(road[0]);
//            list.add(road[1]);
//            map.put(road[0], list);
//            list = map.get(road[1]);
//            list.add(road[0]);
//            map.put(road[1], list);
//        }
//        for (int i = 0; i < cost.length; i++) {
//            List<Integer> use = new ArrayList<>();
//            use.add(i);
//            Map<Integer, List<Integer>> nmap = new HashMap<>();
//            for (int key : map.keySet()) {
//                List<Integer> list = map.get(key);
//                List<Integer> nList = new ArrayList<>();
//                for (Integer integer : list) {
//                    nList.add(integer);
//                }
//                nmap.put(key, nList);
//            }
//            dfs(cost, nmap, cost[i], use, i);
//        }
//        return sum - max;
//    }
//
//    long max = 0;
//
//    private void dfs(int[] cost, Map<Integer, List<Integer>> map, long sum, List<Integer> use, int index) {
//        Map<Integer, List<Integer>> nmap = new HashMap<>();
//        for (int key : map.keySet()) {
//            List<Integer> list = map.get(key);
//            List<Integer> nList = new ArrayList<>();
//            for (Integer integer : list) {
//                nList.add(integer);
//            }
//            nmap.put(key, nList);
//        }
//        List<Integer> list = nmap.get(index);
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (use.contains(list.get(i))) {
//                list.remove(i);
//            }
//        }
//        if (list.size() == 0) {
//            sum -= cost[use.get(0)];
//            max = Math.max(max, sum);
//            return;
//        }
//        for (int num : list) {
//            use.add(num);
//            dfs(cost, nmap, sum + cost[num], use, num);
//            use.remove((Integer) num);
//        }
//    }

}
