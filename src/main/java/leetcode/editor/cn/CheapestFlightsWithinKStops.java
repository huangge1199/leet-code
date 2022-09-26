//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 340 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.*;

//787:K 站中转内最便宜的航班
class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CheapestFlightsWithinKStops().new Solution();
//        TwoArray flights = new TwoArray("[[0,1,100],[1,2,100],[0,2,500]]", true);
//        System.out.println(solution.findCheapestPrice(3, flights.getArr(), 0, 2, 1));
//        TwoArray flights = new TwoArray("[[4,1,1],[1,2,3],[0,3,2],[0,4,10],[3,1,1],[1,4,3]]", true);
//        System.out.println(solution.findCheapestPrice(5, flights.getArr(), 2, 1, 1));
        TwoArray flights = new TwoArray("[[1,2,10],[2,0,7],[1,3,8],[4,0,10],[3,4,2],[4,2,10],[0,3,3],[3,1,6],[2,4,5]]", true);
        System.out.println(solution.findCheapestPrice(5, flights.getArr(), 0, 4, 1));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            k++;
            Map<Integer, List<int[]>> prices = new HashMap<>();
            Queue<QueueEntity> queue = new LinkedList<>();
            int[] sums = new int[n];
            Arrays.fill(sums, Integer.MAX_VALUE);
            for (int[] flight : flights) {
                List<int[]> list = prices.getOrDefault(flight[0], new ArrayList<>());
                list.add(new int[]{flight[1], flight[2]});
                prices.put(flight[0], list);
            }
            queue.add(new QueueEntity(src, 0, new ArrayList<>(Collections.singletonList(src))));
            while (k > 0 && !queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    QueueEntity queueEntity = queue.poll();
                    List<Integer> use = queueEntity.use;
                    if (!prices.containsKey(queueEntity.flight)) {
                        continue;
                    }
                    for (int[] arr : prices.get(queueEntity.flight)) {
                        if (queueEntity.sum + arr[1] >= sums[arr[0]] || queueEntity.use.contains(arr[0])) {
                            continue;
                        }
                        if (arr[0] != dst) {
                            use.add(arr[0]);
                            queue.add(new QueueEntity(arr[0], queueEntity.sum + arr[1], use));
                            use.remove((Integer) arr[0]);
                        }
                        sums[arr[0]] = queueEntity.sum + arr[1];
                    }
                }
                k--;
            }
            return sums[dst] == Integer.MAX_VALUE ? -1 : sums[dst];
        }

        class QueueEntity {
            int flight;
            int sum;
            List<Integer> use;

            public QueueEntity(int flight, int sum, List<Integer> use) {
                this.flight = flight;
                this.sum = sum;
                this.use = use;
            }

            public int getFlight() {
                return flight;
            }

            public void setFlight(int flight) {
                this.flight = flight;
            }

            public int getSum() {
                return sum;
            }

            public void setSum(int sum) {
                this.sum = sum;
            }

            public List<Integer> getUse() {
                return use;
            }

            public void setUse(List<Integer> use) {
                this.use = use;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}