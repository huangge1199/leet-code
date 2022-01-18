//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 151 👎 0

package leetcode.editor.cn;

import java.util.List;

//539:最小时间差
public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] times = new int[2880];
            for (String timePoint : timePoints) {
                String[] strs = timePoint.split(":");
                int time = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
                if (times[time] == 1) {
                    return 0;
                }
                times[time] = 1;
                times[time + 1440] = 1;
            }
            if (times[0] == 1 && times[1439] == 1) {
                return 1;
            }
            int min = 1440;
            int bef = 0;
            for (int i = 1; i < 2880; i++) {
                if (times[i] == 1) {
                    if (bef > 0) {
                        min = Math.min(min, i - bef);
                    }
                    if (i > 1439) {
                        break;
                    }
                    bef = i;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
