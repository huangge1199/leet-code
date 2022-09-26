//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1092 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56:合并区间
class MergeIntervals {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MergeIntervals().new Solution();
//        TwoArray twoArray = new TwoArray("[[1,4],[2,3]]",true);
        TwoArray twoArray = new TwoArray("[[1,3],[2,6],[8,10],[15,18]]", true);
        solution.merge(twoArray.getArr());
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            List<int[]> list = new ArrayList<>();
            int[] bef = intervals[0];
            for (int[] arr : intervals) {
                if (arr[0] <= bef[1]) {
                    bef[1] = Math.max(arr[1], bef[1]);
                } else {
                    list.add(bef);
                    bef = arr;
                }
            }
            list.add(bef);
            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}