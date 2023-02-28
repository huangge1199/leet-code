//<p>给你一个 <code>m x n</code> 的矩阵，最开始的时候，每个单元格中的值都是 <code>0</code>。</p>
//
//<p>另有一个二维索引数组&nbsp;<code>indices</code>，<code>indices[i] = [ri, ci]</code> 指向矩阵中的某个位置，其中 <code>ri</code> 和 <code>ci</code> 分别表示指定的行和列（<strong>从 <code>0</code> 开始编号</strong>）。</p>
//
//<p>对 <code>indices[i]</code> 所指向的每个位置，应同时执行下述增量操作：</p>
//
//<ol> 
// <li><code>r<sub>i</sub></code> 行上的所有单元格，加 <code>1</code> 。</li> 
// <li><code>c<sub>i</sub></code> 列上的所有单元格，加 <code>1</code> 。</li> 
//</ol>
//
//<p>给你 <code>m</code>、<code>n</code> 和 <code>indices</code> 。请你在执行完所有&nbsp;<code>indices</code>&nbsp;指定的增量操作后，返回矩阵中 <strong>奇数值单元格</strong> 的数目。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/06/e1.png" style="height: 118px; width: 600px;" /></p>
//
//<pre>
//<strong>输入：</strong>m = 2, n = 3, indices = [[0,1],[1,1]]
//<strong>输出：</strong>6
//<strong>解释：</strong>最开始的矩阵是 [[0,0,0],[0,0,0]]。
//第一次增量操作后得到 [[1,2,1],[0,1,0]]。
//最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/06/e2.png" style="height: 150px; width: 600px;" /></p>
//
//<pre>
//<strong>输入：</strong>m = 2, n = 2, indices = [[1,1],[0,0]]
//<strong>输出：</strong>0
//<strong>解释：</strong>最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= m, n &lt;= 50</code></li> 
// <li><code>1 &lt;= indices.length &lt;= 100</code></li> 
// <li><code>0 &lt;= r<sub>i</sub> &lt; m</code></li> 
// <li><code>0 &lt;= c<sub>i</sub> &lt; n</code></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>你可以设计一个时间复杂度为 <code>O(n + m + indices.length)</code> 且仅用 <code>O(n + m)</code> 额外空间的算法来解决此问题吗？</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>模拟</li></div></div><br><div><li>👍 142</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 1252:奇数值单元格的数目
public class CellsWithOddValuesInAMatrix {
    public static void main(String[] args) {
        Solution solution = new CellsWithOddValuesInAMatrix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int oddCells(int m, int n, int[][] indices) {
            int[] arrm = new int[m];
            int[] arrn = new int[n];
            for (int[] indix : indices) {
                arrm[indix[0]]++;
                arrn[indix[1]]++;
            }
            int m0 = 0, m1 = 0, n0 = 0, n1 = 0;
            for (int num : arrm) {
                if (num % 2 == 0) {
                    m0++;
                } else {
                    m1++;
                }
            }
            for (int num : arrn) {
                if (num % 2 == 0) {
                    n0++;
                } else {
                    n1++;
                }
            }
            return m0 * n1 + m1 * n0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
