//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 
// 👍 136 👎 0

package leetcode.editor.cn;

//1124:表现良好的最长时间段
public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestWellPerformingInterval().new Solution();
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            int length = hours.length;
            int sum = 0;
            int max = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i; j < length; j++) {
                    sum += hours[j] > 8 ? -1 : 1;
                    if (sum < 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
                sum = 0;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}