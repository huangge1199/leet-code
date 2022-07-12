//<p>哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子<code>&quot;I reset the computer. It still didn&rsquo;t boot!&quot;</code>已经变成了<code>&quot;iresetthecomputeritstilldidntboot&quot;</code>。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典<code>dictionary</code>，不过，有些词没在词典里。假设文章用<code>sentence</code>表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。</p>
//
//<p><strong>注意：</strong>本题相对原题稍作改动，只需返回未识别的字符数</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre><strong>输入：</strong>
//dictionary = [&quot;looked&quot;,&quot;just&quot;,&quot;like&quot;,&quot;her&quot;,&quot;brother&quot;]
//sentence = &quot;jesslookedjustliketimherbrother&quot;
//<strong>输出：</strong> 7
//<strong>解释：</strong> 断句后为&quot;<strong>jess</strong> looked just like <strong>tim</strong> her brother&quot;，共7个未识别字符。
//</pre>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= len(sentence) &lt;= 1000</code></li>
//	<li><code>dictionary</code>中总字符数不超过 150000。</li>
//	<li>你可以认为<code>dictionary</code>和<code>sentence</code>中只包含小写字母。</li>
//</ul>
//<div><div>Related Topics</div><div><li>字典树</li><li>数组</li><li>哈希表</li><li>字符串</li><li>动态规划</li><li>哈希函数</li><li>滚动哈希</li></div></div><br><div><li>👍 198</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.*;

// 面试题 17.13:恢复空格
public class ReSpaceLcci {
    public static void main(String[] args) {
        Solution solution = new ReSpaceLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int respace(String[] dictionary, String sentence) {
            int n = sentence.length();
            int m = dictionary.length;
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1];
                for (String s : dictionary) {
                    if (i < s.length()) {
                        continue;
                    }
                    if (sentence.startsWith(s, i - s.length())) {
                        dp[i] = Math.max(dp[i - s.length()] + s.length(), dp[i]);
                    }
                }
            }
            return n - dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
