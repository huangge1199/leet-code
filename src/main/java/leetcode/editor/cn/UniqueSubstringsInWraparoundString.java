//<p>把字符串 <code>s</code> 看作是&nbsp;<code>“abcdefghijklmnopqrstuvwxyz”</code>&nbsp;的无限环绕字符串，所以&nbsp;<code>s</code> 看起来是这样的：</p>
//
//<ul>
//	<li><code>"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...."</code>&nbsp;.&nbsp;</li>
//</ul>
//
//<p>现在给定另一个字符串 <code>p</code> 。返回<em>&nbsp;<code>s</code> 中&nbsp;<strong>唯一</strong> 的 <code>p</code> 的 <strong>非空子串</strong>&nbsp;的数量&nbsp;</em>。&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入:</strong> p = "a"
//<strong>输出:</strong> 1
//<strong>解释:</strong> 字符串 s 中只有一个"a"子字符。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> p = "cac"
//<strong>输出:</strong> 2
//<strong>解释:</strong> 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入:</strong> p = "zab"
//<strong>输出:</strong> 6
//<strong>解释:</strong> 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= p.length &lt;= 10<sup>5</sup></code></li>
//	<li><code>p</code>&nbsp;由小写英文字母构成</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 267</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

// 467:环绕字符串中唯一的子字符串
public class UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        Solution solution = new UniqueSubstringsInWraparoundString().new Solution();
        // TO TEST
        System.out.println(solution.findSubstringInWraproundString("zaba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] dp = new int[26];
            int count = 1;
            dp[p.charAt(0) - 'a'] = 1;
            for (int i = 1; i < p.length(); i++) {
                int sub = p.charAt(i) - p.charAt(i - 1);
                if (sub == 1 || sub == -25) {
                    count++;
                } else {
                    count = 1;
                }
                dp[p.charAt(i)-'a']=Math.max(dp[p.charAt(i)-'a'],count);
            }
            return Arrays.stream(dp).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

