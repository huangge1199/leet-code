//给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判
//断一个人是否能够参加这里面的全部会议。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁶ 
// 
// Related Topics 数组 排序 👍 117 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//252:会议室
public class MeetingRooms {
    public static void main(String[] args) {
        Solution solution = new MeetingRooms().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
            for (int i = 1; i < intervals.length; i++) {
                if(intervals[i][0]<intervals[i-1][1]){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
