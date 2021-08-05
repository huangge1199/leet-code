//在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。 
//
// 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。 
//
// 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 104 
// 0 <= graph[i].length <= n 
// graph[i] 按严格递增顺序排列。 
// 图中可能包含自环。 
// 图中边的数目在范围 [1, 4 * 104] 内。 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 163 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.*;

//802:找到最终的安全状态
class FindEventualSafeStates {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindEventualSafeStates().new Solution();
        TwoArray array = new TwoArray("[[1,2],[2,3],[5],[0],[5],[],[]]", false);
        System.out.println(solution.eventualSafeNodes(array.getArr()));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] count = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    List<Integer> list = map.getOrDefault(graph[i][j], new ArrayList<>());
                    list.add(i);
                    map.put(graph[i][j], list);
                }
                count[i] = graph[i].length;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < graph.length; i++) {
                if (count[i] == 0) {
                    queue.add(i);
                }
            }
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int num = queue.poll();
                list.add(num);
                if (map.containsKey(num)) {
                    for (Integer integer : map.get(num)) {
                        if (list.contains(integer)) {
                            continue;
                        }
                        count[integer]--;
                        if (count[integer] == 0) {
                            queue.add(integer);
                        }
                    }
                }
            }
            Collections.sort(list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}