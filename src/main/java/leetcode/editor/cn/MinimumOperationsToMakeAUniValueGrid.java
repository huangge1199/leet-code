//给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。 
//
// 单值网格 是全部元素都相等的网格。 
//
// 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,4],[6,8]], x = 2
//输出：4
//解释：可以执行下述操作使所有元素都等于 4 ： 
//- 2 加 x 一次。
//- 6 减 x 一次。
//- 8 减 x 两次。
//共计 4 次操作。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,5],[2,3]], x = 1
//输出：5
//解释：可以使所有元素都等于 3 。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：grid = [[1,2],[3,4]], x = 2
//输出：-1
//解释：无法使所有元素相等。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= x, grid[i][j] <= 10⁴ 
// 
// 👍 8 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//2033:获取单值网格的最小操作数
class MinimumOperationsToMakeAUniValueGrid {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumOperationsToMakeAUniValueGrid().new Solution();
        TwoArray twoArray = new TwoArray("[[146]]", true);
        solution.minOperations(twoArray.getArr(), 86);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[][] grid, int x) {
            List<Integer> list = new ArrayList<>();
            int temp = grid[0][0];
            for (int[] ints : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (Math.abs(ints[j] - temp) % x > 0) {
                        return -1;
                    }
                    list.add(ints[j]);
                }
            }
            Collections.sort(list);
            int num = list.get(list.size() / 2);
            int sum = 0;
            for (Integer integer : list) {
                sum += Math.abs(integer - num) / x;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}