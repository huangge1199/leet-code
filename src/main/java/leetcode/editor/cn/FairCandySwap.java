//<p>爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 <code>aliceSizes</code> 和 <code>bobSizes</code> ，<code>aliceSizes[i]</code> 是爱丽丝拥有的第 <code>i</code> 盒糖果中的糖果数量，<code>bobSizes[j]</code> 是鲍勃拥有的第 <code>j</code> 盒糖果中的糖果数量。</p>
//
//<p>两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。</p>
//
//<p>返回一个整数数组 <code>answer</code>，其中 <code>answer[0]</code> 是爱丽丝必须交换的糖果盒中的糖果的数目，<code>answer[1]</code> 是鲍勃必须交换的糖果盒中的糖果的数目。如果存在多个答案，你可以返回其中 <strong>任何一个</strong> 。题目测试用例保证存在与输入对应的答案。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>aliceSizes = [1,1], bobSizes = [2,2]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>aliceSizes = [1,2], bobSizes = [2,3]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>aliceSizes = [2], bobSizes = [1,3]
//<strong>输出：</strong>[2,3]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>aliceSizes = [1,2,5], bobSizes = [2,4]
//<strong>输出：</strong>[5,4]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= aliceSizes.length, bobSizes.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>1 &lt;= aliceSizes[i], bobSizes[j] &lt;= 10<sup>5</sup></code></li> 
// <li>爱丽丝和鲍勃的糖果总数量不同。</li> 
// <li>题目数据保证对于给定的输入至少存在一个有效答案。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 215</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 888:公平的糖果交换
public class FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new FairCandySwap().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int aliceSum = Arrays.stream(aliceSizes).sum();
            int bobSum = Arrays.stream(bobSizes).sum();
            Set<Integer> set = new HashSet<>();
            for (int num : aliceSizes) {
                set.add(num);
            }
            int sub = aliceSum - bobSum;
            for (int num : bobSizes) {
                if (set.contains(sub / 2 + num)) {
                    return new int[]{sub / 2 + num, num};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
