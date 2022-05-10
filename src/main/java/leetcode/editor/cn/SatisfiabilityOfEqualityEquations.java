//<p>给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 <code>equations[i]</code> 的长度为 <code>4</code>，并采用两种不同的形式之一：<code>&quot;a==b&quot;</code> 或&nbsp;<code>&quot;a!=b&quot;</code>。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。</p>
//
//<p>只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回&nbsp;<code>true</code>，否则返回 <code>false</code>。&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<ol>
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b!=a&quot;]
//<strong>输出：</strong>false
//<strong>解释：</strong>如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>[&quot;b==a&quot;,&quot;a==b&quot;]
//<strong>输出：</strong>true
//<strong>解释：</strong>我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b==c&quot;,&quot;a==c&quot;]
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>[&quot;a==b&quot;,&quot;b!=c&quot;,&quot;c==a&quot;]
//<strong>输出：</strong>false
//</pre>
//
//<p><strong>示例 5：</strong></p>
//
//<pre><strong>输入：</strong>[&quot;c==c&quot;,&quot;b==d&quot;,&quot;x!=z&quot;]
//<strong>输出：</strong>true
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li><code>1 &lt;= equations.length &lt;= 500</code></li>
//	<li><code>equations[i].length == 4</code></li>
//	<li><code>equations[i][0]</code> 和&nbsp;<code>equations[i][3]</code>&nbsp;是小写字母</li>
//	<li><code>equations[i][1]</code> 要么是&nbsp;<code>&#39;=&#39;</code>，要么是&nbsp;<code>&#39;!&#39;</code></li>
//	<li><code>equations[i][2]</code>&nbsp;是&nbsp;<code>&#39;=&#39;</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>并查集</li><li>图</li><li>数组</li><li>字符串</li></div></div><br><div><li>👍 233</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.*;

// 990:等式方程的可满足性
public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
        // TO TEST
        System.out.println(solution.equationsPossible(new String[]{"l!=w", "o==m", "k==y", "s!=d", "q!=t", "b!=i", "d!=q", "p!=f", "o==h", "s!=l", "q!=i", "u==o", "f!=r", "h==h", "i!=t", "u!=d", "v==d", "i!=k", "i!=u", "o==u", "u==a", "e==s", "r!=p", "t!=w", "e!=i", "y!=r", "t!=p", "q!=t", "t!=x", "k!=o", "i!=u", "a!=e", "x!=a", "y!=r", "c==a", "j!=d", "x!=h", "j!=a", "o==c", "y==k", "w==n", "w!=l", "w!=f", "m!=k", "a!=w", "b!=t", "h!=q", "e!=p", "k!=e", "i!=c", "r!=o", "o!=j", "t!=o", "c!=d", "l!=q", "h!=f", "r!=i", "x!=w", "b!=t", "h!=v", "k!=c", "p!=c", "y!=e", "a!=r", "a!=j", "p!=m", "o==h", "a!=g", "f!=r", "f!=v", "s!=r", "y!=a", "y!=o", "r!=m", "s!=p", "y==k", "r!=u", "m==c", "m==c", "a!=g", "x!=v", "h==u", "m!=p", "t!=e", "w!=k", "d!=c", "i!=l", "n!=l", "g!=l", "o!=x", "g!=q", "h!=d", "n==w", "b!=h", "o!=e", "l!=q", "m!=w", "u!=p", "c!=k", "m!=i", "p!=n", "d!=j", "u!=t", "m!=g", "r!=a", "p!=n", "p!=q", "h!=g", "d!=p", "a!=q", "v!=w", "s!=h", "h!=y", "t!=q", "u!=j", "v!=n", "g==g", "f!=y", "b!=t", "w!=u", "b!=w", "j!=m", "x!=f", "l!=y", "a!=g", "u!=x", "l!=o", "g==g", "d!=o", "r!=a", "s!=o", "u!=q", "q!=e", "l!=r", "j!=d", "n!=f", "n!=a", "n!=y", "s!=r", "l!=n", "u!=y", "k!=x", "k!=e", "c!=l", "g!=e", "t!=b", "k!=v", "i!=y", "v==d", "t!=g", "b!=f", "m==o", "q!=p", "q!=e", "b!=g", "o!=t", "h==u", "u!=w", "n!=u", "y!=r", "y!=l", "y!=s", "v!=p", "o==c", "h==h", "l!=p", "q!=d", "f!=y", "s!=x", "t!=a", "x!=k", "t!=m", "f!=u", "i!=v", "i!=n", "s!=f", "p!=j", "v!=w", "o!=k", "y==y", "g!=u", "r!=k", "y==k", "e==s", "d!=k", "o!=f", "y!=n", "p!=t", "e!=m", "w!=k", "g!=e", "n!=u", "p!=v", "q!=u", "m!=t", "p!=d", "s!=b", "l!=q", "f!=g", "q!=k", "h==h", "x!=i", "x!=i", "k!=h", "o==a", "s!=f", "x!=r", "v!=j", "u!=y", "n!=u", "o==u", "a!=g", "q!=w", "f!=b", "o!=p", "n!=x", "j!=i", "g!=c", "u!=p", "x!=d", "d==d", "t!=h", "a!=p", "d!=y", "l!=p", "w!=d", "u==c", "y!=o", "u!=s", "q!=c", "d!=k", "f!=u", "u!=v", "r!=y", "y!=w", "p!=h", "a!=d", "f!=p", "f!=k", "e!=g", "p!=c", "s!=c", "m!=e", "p!=g", "g!=j", "w==n", "r!=t", "b!=o", "r!=i", "c!=w", "u!=q", "y!=u", "y!=x", "n!=y", "g!=p", "g!=o", "m!=l", "h!=w", "v!=b", "s!=n", "y!=s", "t!=s", "p!=r", "v!=w", "x!=u", "t!=k", "g!=r", "j!=y", "p!=y", "h!=g", "r!=y", "l!=w", "g!=k", "m!=f", "u==h", "y!=x", "x!=j", "j!=w", "w!=s", "i!=v", "x!=w", "h!=r", "s!=y", "o!=p", "v!=l", "a!=x", "u==o", "c!=l", "g!=w", "x!=q", "h!=n", "m!=r", "c!=s", "a!=t", "q!=i", "a!=t", "r!=f", "s==e", "c!=d", "w!=c", "e!=u", "e!=j", "h==c", "b!=i", "j!=m", "v!=p", "g!=k", "g!=r", "f==f", "y!=p", "l!=j", "w!=k", "w!=a", "g!=t", "b!=f", "n!=q", "k!=b", "y!=e", "g!=q", "g!=e", "t!=d", "c!=g", "g!=q", "e!=d", "e!=o", "j!=p", "p!=q", "h!=v", "q!=w", "w!=g", "u!=v", "j!=w", "d!=m", "r!=f", "h==o", "h==o", "o!=y", "n!=t", "e!=a", "y!=e", "h!=y", "w!=q", "h!=b", "k!=s", "q!=l", "r!=k", "e==e", "q!=g", "y!=b", "d!=a", "u!=w", "r!=n", "x!=f", "l!=b", "o!=i", "w!=e", "s!=q", "v!=n", "e!=n", "u!=l", "l!=n", "v!=y", "n!=u", "b!=f", "h!=i", "q!=x", "a!=y", "p!=y", "f!=n", "l!=s", "b!=q", "h!=e", "a==u", "h!=t", "p!=a", "o!=f", "d!=f", "j!=x", "n!=p", "b!=r", "t!=w", "g!=i", "o!=k", "t!=v", "t!=s", "g!=b", "l!=a", "n!=j", "g!=a", "e!=v", "q!=w", "w!=i", "n!=u", "d!=y", "l!=e", "g!=c", "u!=x", "k!=o", "y!=d", "t!=n", "b!=y", "s!=g", "l!=i", "t!=h", "n!=k", "o!=f", "h==m", "r!=a", "n!=e", "t!=c", "t!=e", "w!=t", "d!=y", "f!=w", "i!=g", "p!=b", "t!=l", "o!=w", "n!=r", "n!=x", "y!=n", "u!=r", "d!=o", "p!=g", "j!=r", "i!=n", "j!=k", "s!=m", "e!=d", "w==n", "b!=r", "r!=g", "u==c", "p!=s", "q!=f", "j!=k", "g!=k", "k!=w", "b!=t", "k!=t", "u!=g", "m!=p", "a==o", "k!=s", "r!=a", "a==h", "v!=e", "d!=g", "d!=r", "e!=v", "r!=n", "e!=y", "k!=u", "v!=i", "m!=n", "r!=m", "x!=n", "a!=x", "s!=m", "r!=m", "a!=e", "x!=f", "h!=v", "x!=e", "c==c", "q!=i", "e==s", "r!=e", "y!=h", "h!=n", "t!=a", "x!=g", "p!=k", "r!=v", "m!=x", "a!=f", "b!=t", "c!=k", "t!=w", "j!=i", "a!=w", "o!=n", "w!=r", "x!=p", "u==o", "u==u", "p!=x", "v!=p", "s!=b", "q!=w", "t!=k", "m!=q", "b!=l", "d!=h", "l!=j", "d!=r", "d!=m", "u==m", "m==h", "f==r"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            int[] arrs = new int[26];
            boolean[] use = new boolean[equations.length];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int index = 1;
            int in = 0;
            for (String str : equations) {
                int ch1 = str.charAt(0) - 'a';
                int ch2 = str.charAt(3) - 'a';
                if (str.charAt(1) == '!') {
                    if (ch1 == ch2) {
                        return false;
                    }
                } else {
                    use[in] = true;
                    if (arrs[ch1] > 0 && arrs[ch2] > 0) {
                        Set<Integer> list1 = map.get(arrs[ch1]);
                        Set<Integer> list2 = map.get(arrs[ch2]);
                        if (list1.size() > list2.size()) {
                            list1.addAll(list2);
                            for (int i : list2) {
                                arrs[i] = arrs[ch1];
                            }
                            map.remove(arrs[ch2]);
                            map.put(arrs[ch1], list1);
                        } else {
                            list2.addAll(list1);
                            for (int i : list1) {
                                arrs[i] = arrs[ch2];
                            }
                            map.remove(arrs[ch1]);
                            map.put(arrs[ch2], list2);
                        }
                    } else if (arrs[ch1] > 0) {
                        arrs[ch2] = arrs[ch1];
                        Set<Integer> list = map.get(arrs[ch1]);
                        list.add(ch2);
                        map.put(arrs[ch1], list);
                    } else if (arrs[ch2] > 0) {
                        arrs[ch1] = arrs[ch2];
                        Set<Integer> list = map.get(arrs[ch2]);
                        list.add(ch1);
                        map.put(arrs[ch2], list);
                    } else {
                        arrs[ch1] = index;
                        arrs[ch2] = index;
                        Set<Integer> list = new HashSet<>();
                        list.add(ch1);
                        list.add(ch2);
                        map.put(index, list);
                        index++;
                    }
                }
                in++;
            }
            for (int i = 0; i < equations.length; i++) {
                if (use[i]) {
                    continue;
                }
                String str = equations[i];
                int ch1 = str.charAt(0) - 'a';
                int ch2 = str.charAt(3) - 'a';
                if (arrs[ch1] == arrs[ch2] && arrs[ch1] != 0 && arrs[ch2] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
