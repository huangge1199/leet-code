//给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。 
//
// 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。 
//
//
// 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。 
//
// 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//输出：[3,2,2]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
// 
//
// 示例 2： 
//
// 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,
//2],[4,3,3]]
//输出：[2,3,2,4]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// points[i].length == 2 
// 0 <= xi, yi <= 500 
// 1 <= queries.length <= 500 
// queries[j].length == 3 
// 0 <= xj, yj <= 500 
// 1 <= rj <= 500 
// 所有的坐标都是整数。 
// 
// Related Topics 数学 
// 👍 5 👎 0

package leetcode.editor.cn;

//1828:统计一个圆中点的数目
public class QueriesOnNumberOfPointsInsideACircle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new QueriesOnNumberOfPointsInsideACircle().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int size = queries.length;
            int[] result = new int[size];
            for (int i = 0; i < size; i++) {
                int num = 0;
                int length = points.length;
                int c = queries[i][2];
                for (int[] point : points) {
                    int x = Math.abs(queries[i][0] - point[0]);
                    int y = Math.abs(queries[i][1] - point[1]);
                    if (x * x + y * y <= c * c) {
                        num++;
                    }
                }
                result[i] = num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}