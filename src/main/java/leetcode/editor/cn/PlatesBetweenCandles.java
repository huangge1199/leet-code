//给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|
//' 表示一支 蜡烛 。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[
//lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边
// 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。 
//
// 
// 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符
//串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
//输出：[2,3]
//解释：
//- queries[0] 有两个盘子在蜡烛之间。
//- queries[1] 有三个盘子在蜡烛之间。
// 
//
// 示例 2: 
//
// 
//
// 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16
//]]
//输出：[9,0,0,0,0]
//解释：
//- queries[0] 有 9 个盘子在蜡烛之间。
//- 另一个查询没有盘子在蜡烛之间。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s 只包含字符 '*' 和 '|' 。 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// 0 <= lefti <= righti < s.length 
// 
// Related Topics 数组 字符串 二分查找 前缀和 👍 141 👎 0

package leetcode.editor.cn;

//2055:蜡烛之间的盘子
public class PlatesBetweenCandles {
    public static void main(String[] args) {
        Solution solution = new PlatesBetweenCandles().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int[] platesBetweenCandles(String s, int[][] queries) {
//            int[] result = new int[queries.length];
//            int index = 0;
//            for (int[] query : queries) {
//                String tmp = s.substring(query[0], query[1] + 1);
//                while (tmp.startsWith("*")) {
//                    tmp = tmp.substring(1);
//                }
//                while (tmp.endsWith("*")) {
//                    tmp = tmp.substring(0, tmp.length() - 1);
//                }
//                tmp = tmp.replace("|","");
//                result[index] = tmp.length();
//                index++;
//            }
//            return result;
//        }
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] ans = new int[queries.length];
            // 计算左侧距离最近的蜡烛下标
            int[] preCandleIndex = getPreCandleIndex(s);
            // 计算右侧距离最近的蜡烛下标
            int[] nextCandleIndex = getNextCandleIndex(s);
            // 计算前缀和
            int[] prePlatesSum = getPrePlatesSum(s);

            for (int i = 0; i < queries.length; ++i) {
                // 得到左侧最近的蜡烛下标
                int left = nextCandleIndex[queries[i][0]];
                // 得到右侧最近的蜡烛下标
                int right = preCandleIndex[queries[i][1]];
                // 处理特殊情况
                if (left == -1 || right == -1 || left > right) {
                    ans[i] = 0;
                } else {
                    // 前缀和相减
                    ans[i] = prePlatesSum[right] - prePlatesSum[left];
                }
            }
            return ans;
        }

        private int[] getPrePlatesSum(String s) {
            int[] ans = new int[s.length()];
            for (int i = 0; i < s.length(); ++i) {
                // 第一个位置前缀和为0
                if (i == 0) {
                    ans[i] = 0;
                } else {
                    // 首先得到前一个位置的前缀和
                    ans[i] = ans[i] + ans[i - 1];
                }
                // 若当前位置为盘子，和加1
                if (s.charAt(i) == '*') {
                    ++ans[i];
                }
            }
            return ans;
        }

        private int[] getNextCandleIndex(String s) {
            int[] ans = new int[s.length()];
            int temp = -1;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '|') {
                    temp = i;
                }
                ans[i] = temp;
            }
            return ans;
        }

        private int[] getPreCandleIndex(String s) {
            int[] ans = new int[s.length()];
            int temp = -1;
            for (int i = 0; i < s.length(); ++i) {
                // 遇到蜡烛则更新下标
                if (s.charAt(i) == '|') {
                    temp = i;
                }
                ans[i] = temp;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
