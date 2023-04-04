////有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 313 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

// 1000:合并石头的最低成本
public class MinimumCostToMergeStones {
    public static void main(String[] args) {
        Solution solution = new MinimumCostToMergeStones().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mergeStones(int[] stones, int k) {
            int size = stones.length;
            if ((size - 1) % (k - 1) != 0) {
                return -1;
            }
            int[][] dp = new int[size][size];
            for (int i = 0; i < size; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            int[] sum = new int[size];
            dp[0][0] = 0;
            sum[0] = stones[0];
            for (int i = 1; i < size; i++) {
                dp[i][i] = 0;
                sum[i] = sum[i - 1] + stones[i];
            }
            for (int len = 2; len <= size; len++) {
                for (int start = 0; start < size && start + len - 1 < size; start++) {
                    int end = start + len - 1;
                    for (int p = start; p < end; p += k - 1) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][p] + dp[p + 1][end]);
                    }
                    if ((end - start) % (k - 1) == 0) {
                        dp[start][end] += sum[end] - (start == 0 ? 0 : sum[start - 1]);
                    }
                }
            }
            return dp[0][size - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}