//在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。 
//
// 这座城市对这些新建筑有一些规定： 
//
// 
// 每栋建筑的高度必须是一个非负整数。 
// 第一栋建筑的高度 必须 是 0 。 
// 任意两栋相邻建筑的高度差 不能超过 1 。 
// 
//
// 除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [id
//i, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。 
//
// 题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。 
//
// 请你返回 最高 建筑能达到的 最高高度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, restrictions = [[2,1],[4,1]]
//输出：2
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,1,2] ，最高建筑的高度为 2 。 
//
// 示例 2： 
//
// 
//输入：n = 6, restrictions = []
//输出：5
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,3,4,5] ，最高建筑的高度为 5 。
// 
//
// 示例 3： 
//
// 
//输入：n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
//输出：5
//解释：上图中的绿色区域为每栋建筑被允许的最高高度。
//我们可以使建筑高度分别为 [0,1,2,3,3,4,4,5,4,3] ，最高建筑的高度为 5 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 109 
// 0 <= restrictions.length <= min(n - 1, 105) 
// 2 <= idi <= n 
// idi 是 唯一的 。 
// 0 <= maxHeighti <= 109 
// 
// Related Topics 贪心算法 二分查找 
// 👍 3 👎 0

package leetcode.editor.cn;

import java.util.*;

//5741:最高建筑高度
public class MaximumBuildingHeight {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumBuildingHeight().new Solution();
        //2
        System.out.println(solution.maxBuilding(5, new int[][]{{2, 1}, {4, 1}}));
        //5
        System.out.println(solution.maxBuilding(6, new int[][]{}));
        //5
        System.out.println(solution.maxBuilding(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxBuilding(int n, int[][] restrictions) {
            Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

            for (int i = restrictions.length - 1; i > 0; i--) {
                restrictions[i - 1][1] = Math.min(restrictions[i - 1][1],
                        restrictions[i][1] + restrictions[i][0] - restrictions[i - 1][0]);
            }

            int max = 0;
            int last = 0;
            int id = 1;
            for (int[] restriction : restrictions){
                int nextid = restriction[0];
                int limit = restriction[1];
                limit = Math.min(limit, nextid - id + last);

                max = Math.max(max, (last + limit + nextid - id)/2);

                last = limit;
                id = nextid;
            }
            if (id < n){
                max = Math.max(max, (n + Math.min(n, n - id + last) + last - id)/2);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}