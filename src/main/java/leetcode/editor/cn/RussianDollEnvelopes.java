//<p>给你一个二维整数数组 <code>envelopes</code> ，其中 <code>envelopes[i] = [w<sub>i</sub>, h<sub>i</sub>]</code> ，表示第 <code>i</code> 个信封的宽度和高度。</p>
//
//<p>当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>
//
//<p>请计算 <strong>最多能有多少个</strong> 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。</p>
//
//<p><strong>注意</strong>：不允许旋转信封。</p> &nbsp;
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>envelopes = [[5,4],[6,4],[6,7],[2,3]]
//<strong>输出：</strong>3
//<strong>解释：</strong>最多信封的个数为 <span><code>3, 组合为: </code></span>[2,3] =&gt; [5,4] =&gt; [6,7]。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>envelopes = [[1,1],[1,1],[1,1]]
//<strong>输出：</strong>1
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= envelopes.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>envelopes[i].length == 2</code></li> 
// <li><code>1 &lt;= w<sub>i</sub>, h<sub>i</sub> &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>动态规划</li><li>排序</li></div></div><br><div><li>👍 881</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 354:俄罗斯套娃信封问题
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes.length == 0) {
                return 0;
            }
            int n = envelopes.length;
            Arrays.sort(envelopes, new Comparator<int[]>() {
                public int compare(int[] e1, int[] e2) {
                    if (e1[0] != e2[0]) {
                        return e1[0] - e2[0];
                    } else {
                        return e2[1] - e1[1];
                    }
                }
            });
            List<Integer> f = new ArrayList<Integer>();
            f.add(envelopes[0][1]);
            for (int i = 1; i < n; ++i) {
                int num = envelopes[i][1];
                if (num > f.get(f.size() - 1)) {
                    f.add(num);
                } else {
                    int index = binarySearch(f, num);
                    f.set(index, num);
                }
            }
            return f.size();
        }
        public int binarySearch(List<Integer> f, int target) {
            int low = 0, high = f.size() - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (f.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
