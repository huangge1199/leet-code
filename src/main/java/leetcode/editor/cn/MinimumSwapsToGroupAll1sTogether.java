//<p>给出一个二进制数组&nbsp;<code>data</code>，你需要通过交换位置，将数组中 <strong>任何位置</strong> 上的 1 组合到一起，并返回所有可能中所需&nbsp;<strong>最少的交换次数</strong>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> data = [1,0,1,0,1]
//<strong>输出:</strong> 1
//<strong>解释: </strong>
//有三种可能的方法可以把所有的 1 组合在一起：
//[1,1,1,0,0]，交换 1 次；
//[0,1,1,1,0]，交换 2 次；
//[0,0,1,1,1]，交换 1 次。
//所以最少的交换次数为 1。
//</pre>
//
//<p><strong>示例&nbsp; 2:</strong></p>
//
//<pre>
//<strong>输入：</strong>data =&nbsp;[0,0,0,1,0]
//<strong>输出：</strong>0
//<strong>解释： </strong>
//由于数组中只有一个 1，所以不需要交换。</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入：</strong>data =&nbsp;[1,0,1,0,1,0,0,1,1,0,1]
//<strong>输出：3
//解释：
//</strong>交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
//</pre>
//
//<p><strong>示例 4:</strong></p>
//
//<pre>
//<strong>输入:</strong> data = [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1]
//<strong>输出:</strong> 8
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= data.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>data[i]</code>&nbsp;==&nbsp;<code>0</code>&nbsp;or&nbsp;<code>1</code>.</li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 1151:最少交换次数来组合所有的 1
public class MinimumSwapsToGroupAll1sTogether {
    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToGroupAll1sTogether().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwaps(int[] data) {
            int size = data.length;
            int[] sums = new int[size + 1];
            for (int i = 0; i < size; i++) {
                sums[i + 1] = sums[i] + data[i];
            }
            int max = 0;
            for (int i = sums[size]; i < size + 1; i++) {
                max = Math.max(max, sums[i] - sums[i - sums[size]]);
            }
            return sums[size] - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
