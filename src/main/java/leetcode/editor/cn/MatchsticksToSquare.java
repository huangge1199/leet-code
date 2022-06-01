//<p>你将得到一个整数数组 <code>matchsticks</code> ，其中 <code>matchsticks[i]</code> 是第 <code>i</code>&nbsp;个火柴棒的长度。你要用 <strong>所有的火柴棍</strong>&nbsp;拼成一个正方形。你 <strong>不能折断</strong> 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 <strong>使用一次</strong> 。</p>
//
//<p>如果你能使这个正方形，则返回 <code>true</code> ，否则返回 <code>false</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<p><img src="https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg" /></p>
//
//<pre>
//<strong>输入:</strong> matchsticks = [1,1,2,2,2]
//<strong>输出:</strong> true
//<strong>解释:</strong> 能拼成一个边长为2的正方形，每边两根火柴。
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入:</strong> matchsticks = [3,3,3,3,4]
//<strong>输出:</strong> false
//<strong>解释:</strong> 不能用所有火柴拼成一个正方形。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= matchsticks.length &lt;= 15</code></li>
//	<li><code>1 &lt;= matchsticks[i] &lt;= 10<sup>8</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>动态规划</li><li>回溯</li><li>状态压缩</li></div></div><br><div><li>👍 316</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;

// 473:火柴拼正方形
public class MatchsticksToSquare {
    public static void main(String[] args) {
        Solution solution = new MatchsticksToSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            Arrays.sort(matchsticks);
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0 || matchsticks[matchsticks.length - 1] > sum / 4) {
                return false;
            }
            int avg = sum / 4;
            return dfs(matchsticks, matchsticks.length - 1, new int[]{avg, avg, avg, avg});
        }

        private boolean dfs(int[] matchsticks, int index, int[] sums) {
            if (index == -1) {
                for (int i = 0; i < 4; i++) {
                    if (sums[i] != 0) {
                        return false;
                    }
                }
                return true;
            }
            int num = matchsticks[index];
            for (int i = 0; i < 4; i++) {
                if (sums[i] - num < 0) {
                    continue;
                }
                sums[i] -= num;
                if (dfs(matchsticks, index - 1, sums)) {
                    return true;
                }
                sums[i] += num;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
