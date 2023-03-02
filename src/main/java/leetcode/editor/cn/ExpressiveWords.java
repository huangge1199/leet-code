//<p>有时候人们会用重复写一些字母来表示额外的感受，比如 <code>"hello" -&gt; "heeellooo"</code>, <code>"hi" -&gt; "hiii"</code>。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。</p>
//
//<p>对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母&nbsp;<code>c</code>&nbsp;），然后往其中添加相同的字母&nbsp;<code>c</code>&nbsp;使其长度达到 3 或以上。</p>
//
//<p>例如，以&nbsp;"hello" 为例，我们可以对字母组&nbsp;"o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于&nbsp;3。此外，我们可以进行另一种扩张 "ll" -&gt; "lllll" 以获得&nbsp;"helllllooo"。如果&nbsp;<code>s = "helllllooo"</code>，那么查询词&nbsp;"hello" 是可扩张的，因为可以对它执行这两种扩张操作使得&nbsp;<code>query = "hello" -&gt; "hellooo" -&gt;&nbsp;"helllllooo" = s</code>。</p>
//
//<p>输入一组查询单词，输出其中可扩张的单词数量。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong> 
//s = "heeellooo"
//words = ["hello", "hi", "helo"]
//<strong>输出：</strong>1
//<strong>解释</strong>：
//我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
//我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length, words.length &lt;= 100</code></li> 
// <li><code>1 &lt;= words[i].length &lt;= 100</code></li> 
// <li><font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace"><span style="font-size: 12.6px; background-color: rgb(249, 242, 244);">s</span></font> 和所有在&nbsp;<code>words</code>&nbsp;中的单词都只由小写字母组成。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 122</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 809:情感丰富的文字
public class ExpressiveWords {
    public static void main(String[] args) {
        Solution solution = new ExpressiveWords().new Solution();
        // TO TEST
        solution.expressiveWords("abcd", new String[]{"abc"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int expressiveWords(String s, String[] words) {
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(words));
            int cnt = 0;
            while (!queue.isEmpty() && s.length() > 0) {
                int size = queue.size();
                char ch = s.charAt(0);
                s = s.substring(1);
                int num = 1;
                while (s.startsWith("" + ch + ch)) {
                    while (s.startsWith("" + ch)) {
                        s = s.substring(1);
                        num++;
                    }
                }
                for (int i = 0; i < size; i++) {
                    String str = queue.poll();
                    int num1 = num;
                    while (str.startsWith("" + ch) && num1 > 0) {
                        str = str.substring(1);
                        num1--;
                    }
                    if (num1 < num && str.length() > 0) {
                        queue.add(str);
                    }
                    if (s.equals("") && str.equals("")) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
