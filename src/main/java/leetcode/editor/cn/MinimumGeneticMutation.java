//<p>基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 <code>'A'</code>、<code>'C'</code>、<code>'G'</code> 和 <code>'T'</code> 之一。</p>
//
//<p>假设我们需要调查从基因序列&nbsp;<code>start</code> 变为 <code>end</code> 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。</p>
//
//<ul> 
// <li>例如，<code>"AACCGGTT" --&gt; "AACCGGTA"</code> 就是一次基因变化。</li> 
//</ul>
//
//<p>另有一个基因库 <code>bank</code> 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 <code>bank</code> 中）</p>
//
//<p>给你两个基因序列 <code>start</code> 和 <code>end</code> ，以及一个基因库 <code>bank</code> ，请你找出并返回能够使&nbsp;<code>start</code> 变化为 <code>end</code> 所需的最少变化次数。如果无法完成此基因变化，返回 <code>-1</code> 。</p>
//
//<p>注意：起始基因序列&nbsp;<code>start</code> 默认是有效的，但是它并不一定会出现在基因库中。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
//<strong>输出：</strong>3
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>start.length == 8</code></li> 
// <li><code>end.length == 8</code></li> 
// <li><code>0 &lt;= bank.length &lt;= 10</code></li> 
// <li><code>bank[i].length == 8</code></li> 
// <li><code>start</code>、<code>end</code> 和 <code>bank[i]</code> 仅由字符 <code>['A', 'C', 'G', 'T']</code> 组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>广度优先搜索</li><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 242</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

// 433:最小基因变化
public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        // TO TEST
        solution.minMutation("AACCGGTT","AAACGGTA",new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            List<String> vist = Arrays.stream(bank).collect(Collectors.toList());
            if (!vist.contains(endGene)) {
                return -1;
            }
            List<String> use = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(startGene);
            use.add(startGene);
            char[] chs = new char[]{'A', 'C', 'G', 'T'};
            int step = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String str = queue.poll();
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 4; k++) {
                            if (chs[k] == str.charAt(j)) {
                                continue;
                            }
                            StringBuffer sb = new StringBuffer(str);
                            sb.setCharAt(j,chs[k]);
                            String tmp = sb.toString();
                            if(tmp.equals(endGene)){
                                return step;
                            }
                            if(vist.contains(tmp)&& !use.contains(tmp)){
                                queue.add(tmp);
                                use.add(tmp);
                            }
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
