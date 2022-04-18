//<p>给你一个整数 <code>n</code> ，按字典序返回范围 <code>[1, n]</code> 内所有整数。</p>
//
//<p>你必须设计一个时间复杂度为 <code>O(n)</code> 且使用 <code>O(1)</code> 额外空间的算法。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 13
//<strong>输出：</strong>[1,10,11,12,13,2,3,4,5,6,7,8,9]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 2
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>字典树</li></div></div><br><div><li>👍 277</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 386:字典序排数
public class LexicographicalNumbers {
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        // TO TEST
        solution.lexicalOrder(13);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            dfs(n, 1);
            return list;
        }

        List<Integer> list = new ArrayList<>();

        private void dfs(int n, int num) {
            if (num > n) {
                return;
            }
            list.add(num);
            dfs(n, num * 10);
            if (num % 10 == 0 || num == 1) {
                int max = (num / 10 + 1) * 10;
                for (int i = num + 1; i < max; i++) {
                    dfs(n, i);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
