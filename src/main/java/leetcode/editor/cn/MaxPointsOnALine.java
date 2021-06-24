//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 哈希表 数学 
// 👍 257 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//149:直线上最多的点数
public class MaxPointsOnALine {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaxPointsOnALine().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            Map<Map<Double, Double>, List<Integer>> map = new HashMap<>();
            int count = 1;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    double sub = points[j][0] - points[i][0];
                    double x, y;
                    if (sub == 0) {
                        x = points[i][0];
                        y = Integer.MAX_VALUE;
                    } else {
                        x = (points[j][1] - points[i][1]) / sub;
                        y = (points[j][0] * points[i][1] - points[i][0] * points[j][1]) / sub;
                    }
                    Map<Double, Double> key = new HashMap<>();
                    key.put(x, y);
                    List<Integer> list = new ArrayList<>();
                    if (map.containsKey(key)) {
                        list = map.get(key);
                        if (!list.contains(i)) {
                            list.add(i);
                        }
                        if (!list.contains(j)) {
                            list.add(j);
                        }
                    } else {
                        list.add(i);
                        list.add(j);
                    }
                    count = Math.max(count, list.size());
                    map.put(key, list);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}