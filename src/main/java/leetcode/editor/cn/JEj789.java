//<p>假如有一排房子，共 <code>n</code> 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。</p>
//
//<p>当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个&nbsp;<code>n x 3</code><em>&nbsp;</em>的正整数矩阵 <code>costs</code> 来表示的。</p>
//
//<p>例如，<code>costs[0][0]</code> 表示第 0 号房子粉刷成红色的成本花费；<code>costs[1][2]</code>&nbsp;表示第 1 号房子粉刷成绿色的花费，以此类推。</p>
//
//<p>请计算出粉刷完所有房子最少的花费成本。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入: </strong>costs = [[17,2,17],[16,16,5],[14,3,19]]
//<strong>输出: </strong>10
//<strong>解释: </strong>将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色<strong>。</strong>
//&nbsp;    最少花费: 2 + 5 + 3 = 10。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入: </strong>costs = [[7,6,2]]
//<strong>输出: 2</strong>
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>costs.length == n</code></li>
//	<li><code>costs[i].length == 3</code></li>
//	<li><code>1 &lt;= n &lt;= 100</code></li>
//	<li><code>1 &lt;= costs[i][j] &lt;= 20</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><meta charset="UTF-8" />注意：本题与主站 256&nbsp;题相同：<a href="https://leetcode-cn.com/problems/paint-house/">https://leetcode-cn.com/problems/paint-house/</a></p>
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 77</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 剑指 Offer II 091:粉刷房子
public class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int length = costs.length;
            int[][] mins = new int[length][3];
            mins[0] = costs[0];
            for (int i = 1; i < length; i++) {
                mins[i][0] = costs[i][0] + Math.min(mins[i - 1][1], mins[i - 1][2]);
                mins[i][1] = costs[i][1] + Math.min(mins[i - 1][0], mins[i - 1][2]);
                mins[i][2] = costs[i][2] + Math.min(mins[i - 1][0], mins[i - 1][1]);
            }
            return Math.min(Math.min(mins[length-1][0],mins[length-1][1]),mins[length-1][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
