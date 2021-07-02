//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 
// 
// Related Topics 广度优先搜索 数组 哈希表 
// 👍 149 👎 0

package leetcode.editor.cn;

import java.util.*;

//815:公交路线
public class BusRoutes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BusRoutes().new Solution();
        System.out.println(solution.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int numBusesToDestination(int[][] routes, int source, int target) {
//            Map<Integer, List<Integer>> site = new HashMap<>();
//            Map<Integer, List<Integer>> bus = new HashMap<>();
//            for (int i = 0; i < routes.length; i++) {
//                List<Integer> busList = new ArrayList<>();
//                for (int j = 0; j < routes[i].length; j++) {
//                    List<Integer> list = site.getOrDefault(routes[i][j], new ArrayList<>());
//                    list.add(i);
//                    site.put(routes[i][j], list);
//                    busList.add(routes[i][j]);
//                }
//                bus.put(i, busList);
//            }
//            int count = minCount(site, bus, source, target, 0, new ArrayList<>());
//            return count == Integer.MAX_VALUE ? -1 : count;
//        }
//
//        private int minCount(Map<Integer, List<Integer>> map, Map<Integer, List<Integer>> bus, int source, int target, int count, List<Integer> use) {
//            if (source == target) {
//                return count;
//            }
//            if (map.get(source).size() == 1 && use.contains(map.get(source).get(0))) {
//                return Integer.MAX_VALUE;
//            }
//            int min = Integer.MAX_VALUE;
//            for (int busIndex : map.get(source)) {
//                if (use.contains(busIndex)) {
//                    continue;
//                }
//                for (int stata : bus.get(busIndex)) {
//                    if (stata == source) {
//                        continue;
//                    }
//                    use.add(busIndex);
//                    min = Math.min(min, minCount(map, bus, stata, target, count + 1, use));
//                    use.remove(use.size() - 1);
//                }
//            }
//            return min;
//        }
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }

            int n = routes.length;
            boolean[][] edge = new boolean[n][n];
            Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                for (int site : routes[i]) {
                    List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                    for (int j : list) {
                        edge[i][j] = edge[j][i] = true;
                    }
                    list.add(i);
                    rec.put(site, list);
                }
            }

            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            Queue<Integer> que = new LinkedList<Integer>();
            for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
                dis[bus] = 1;
                que.offer(bus);
            }
            while (!que.isEmpty()) {
                int x = que.poll();
                for (int y = 0; y < n; y++) {
                    if (edge[x][y] && dis[y] == -1) {
                        dis[y] = dis[x] + 1;
                        que.offer(y);
                    }
                }
            }

            int ret = Integer.MAX_VALUE;
            for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
                if (dis[bus] != -1) {
                    ret = Math.min(ret, dis[bus]);
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}