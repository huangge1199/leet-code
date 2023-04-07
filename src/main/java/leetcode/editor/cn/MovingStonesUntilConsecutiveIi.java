//<p>在一个长度 <strong>无限 </strong>的数轴上，第 <code>i</code> 颗石子的位置为&nbsp;<code>stones[i]</code>。如果一颗石子的位置最小/最大，那么该石子被称作 <strong>端点石子 </strong>。</p>
//
//<p>每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。</p>
//
//<p>值得注意的是，如果石子像&nbsp;<code>stones = [1,2,5]</code>&nbsp;这样，你将 <strong>无法 </strong>移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。</p>
//
//<p>当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。</p>
//
//<p>要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：<code>answer = [minimum_moves, maximum_moves]</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>[7,4,9]
//<strong>输出：</strong>[1,2]
//<strong>解释：</strong>
//我们可以移动一次，4 -&gt; 8，游戏结束。
//或者，我们可以移动两次 9 -&gt; 5，4 -&gt; 6，游戏结束。
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>[6,5,4,3,10]
//<strong>输出：</strong>[2,3]
//<strong>解释：</strong>
//我们可以移动 3 -&gt; 8，接着是 10 -&gt; 7，游戏结束。
//或者，我们可以移动 3 -&gt; 7, 4 -&gt; 8, 5 -&gt; 9，游戏结束。
//注意，我们无法进行 10 -&gt; 2 这样的移动来结束游戏，因为这是不合要求的移动。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>[100,101,104,102,103]
//<strong>输出：</strong>[0,0]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= stones.length &lt;= 10^4</code></li> 
// <li><code>1 &lt;= stones[i] &lt;= 10^9</code></li> 
// <li><code>stones[i]</code>&nbsp;的值各不相同。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 165</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;

// 1040:移动石子直到连续 II
public class MovingStonesUntilConsecutiveIi {
    public static void main(String[] args) {
        Solution solution = new MovingStonesUntilConsecutiveIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            int size = stones.length;
            Arrays.sort(stones);
            if (stones[size - 1] - stones[0] + 1 == size) {
                return new int[]{0, 0};
            }
            int max = Math.max(stones[size - 2] - stones[0] + 1, stones[size - 1] - stones[1] + 1) - (size - 1);
            int min = size;
            for (int i = 0; i < size; ++i) {
                int j = 0;
                while (j + 1 < size && stones[j + 1] - stones[i] + 1 <= size) {
                    j++;
                }
                if (j - i + 1 == size - 1 && stones[j] - stones[i] + 1 == size - 1) {
                    min = Math.min(min, 2);
                } else {
                    min = Math.min(min, size - (j - i + 1));
                }
            }
            return new int[]{min, max};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
