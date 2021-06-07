//给你一个 m x n 的整数矩阵 grid 。 
//
// 菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。下图是四个可行的菱形，每个菱形和
//应该包含的格子都用了相应颜色标注在图中。 
//
// 
//
// 注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。 
//
// 请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
//输出：[228,216,211]
//解释：最大的三个菱形和如上图所示。
//- 蓝色：20 + 3 + 200 + 5 = 228
//- 红色：200 + 2 + 10 + 4 = 216
//- 绿色：5 + 200 + 4 + 2 = 211
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[20,9,8]
//解释：最大的三个菱形和如上图所示。
//- 蓝色：4 + 2 + 6 + 8 = 20
//- 红色：9 （右下角红色的面积为 0 的菱形）
//- 绿色：8 （下方中央面积为 0 的菱形）
// 
//
// 示例 3： 
//
// 
//输入：grid = [[7,7,7]]
//输出：[7]
//解释：所有三个可能的菱形和都相同，所以返回 [7] 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// 1 <= grid[i][j] <= 105 
// 
// Related Topics 数组 数学 
// 👍 8 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//1878:矩阵中最大的三个菱形和
public class GetBiggestThreeRhombusSumsInAGrid{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GetBiggestThreeRhombusSumsInAGrid().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        new TreeSet<>(Comparator.reverseOrder());
        int xLength = grid.length;
        int yLength = grid[0].length;
        int size = (Math.min(xLength, yLength) + 1) / 2;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < xLength - i; j++) {
                for (int k = i; k < yLength - i; k++) {
                    int sum = 0;
                    for (int x = j - i; x <= j + i; x++) {
                        int cha = i - Math.abs(j - x);
                        if (Math.abs(j - x) == i) {
                            sum += grid[x][k + cha];
                        } else {
                            sum += grid[x][k - cha] + grid[x][k + cha];
                        }
                    }
                    set.add(sum);
                }
            }
        }
        List<Integer> list = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int length = Math.min(list.size(), 3);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}