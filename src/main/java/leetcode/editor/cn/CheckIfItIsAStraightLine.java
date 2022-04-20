//<p>给定一个数组&nbsp;<code>coordinates</code>&nbsp;，其中&nbsp;<code>coordinates[i] = [x, y]</code>&nbsp;，<meta charset="UTF-8" />&nbsp;<code>[x, y]</code>&nbsp;表示横坐标为 <code>x</code>、纵坐标为 <code>y</code>&nbsp;的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/19/untitled-diagram-2.jpg" /></p>
//
//<pre>
//<strong>输入：</strong>coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/10/19/untitled-diagram-1.jpg" /></strong></p>
//
//<pre>
//<strong>输入：</strong>coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>2 &lt;=&nbsp;coordinates.length &lt;= 1000</code></li>
//	<li><code>coordinates[i].length == 2</code></li>
//	<li><code>-10^4 &lt;=&nbsp;coordinates[i][0],&nbsp;coordinates[i][1] &lt;= 10^4</code></li>
//	<li><code>coordinates</code>&nbsp;中不含重复的点</li>
//</ul>
//<div><div>Related Topics</div><div><li>几何</li><li>数组</li><li>数学</li></div></div><br><div><li>👍 112</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.code.leet.entiy.TwoArray;

// 1232:缀点成线
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();
        // TO TEST
        TwoArray twoArray = new TwoArray("[[0,1],[1,3],[-4,-7],[5,11]]",true);
        System.out.println(solution.checkStraightLine(twoArray.getArr()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length == 2) {
                return true;
            }
            int x = coordinates[1][0] - coordinates[0][0];
            int y = coordinates[1][1] - coordinates[0][1];
            for (int i = 2; i < coordinates.length; i++) {
                int tx = coordinates[i][0] - coordinates[i - 1][0];
                int ty = coordinates[i][1] - coordinates[i - 1][1];
                if (x * ty != y * tx) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
