//城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。 
//
// 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示： 
//
//
// 
// lefti 是第 i 座建筑物左边缘的 x 坐标。 
// righti 是第 i 座建筑物右边缘的 x 坐标。 
// heighti 是第 i 座建筑物的高度。 
// 
//
// 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
//列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。 
//
// 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答
//案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...] 
//
// 
//
// 示例 1： 
//
// 
//输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//解释：
//图 A 显示输入的所有建筑物的位置和高度，
//图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。 
//
// 示例 2： 
//
// 
//输入：buildings = [[0,2,3],[2,5,3]]
//输出：[[0,3],[5,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= buildings.length <= 104 
// 0 <= lefti < righti <= 231 - 1 
// 1 <= heighti <= 231 - 1 
// buildings 按 lefti 非递减排序 
// 
// Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列） 
// 👍 457 👎 0

package leetcode.editor.cn;

import java.util.*;

//218:天际线问题
public class TheSkylineProblem {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TheSkylineProblem().new Solution();
        solution.getSkyline(new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        });
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<Integer> indexs = new ArrayList<>();
            for (int[] building : buildings) {
                indexs.add(building[0]);
                indexs.add(building[1]);
            }
            Collections.sort(indexs);

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//            Queue<int[]> queue = new LinkedList<>();
            List<List<Integer>> ret = new ArrayList<>();
            int cur = 0;
            for (int index : indexs) {
                while (cur < buildings.length && buildings[cur][0] <= index) {
                    queue.offer(new int[]{buildings[cur][1], buildings[cur][2]});
//                    Queue<int[]> temp = new LinkedList<>();
//                    while (!queue.isEmpty()&&queue.peek()[1]>buildings[cur][2]){
//                        temp.offer(queue.poll());
//                    }
//                    queue.offer(new int[]{buildings[cur][1], buildings[cur][2]});
//                    while (!temp.isEmpty()){
//                        queue.offer(temp.poll());
//                    }
                    cur++;
                }
                while (!queue.isEmpty() && queue.peek()[0] <= index) {
                    queue.poll();
                }

                int max = queue.isEmpty() ? 0 : queue.peek()[1];
                if (ret.size() == 0 || max != ret.get(ret.size() - 1).get(1)) {
                    ret.add(Arrays.asList(index, max));
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}