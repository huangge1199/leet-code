//<p>给定字符串&nbsp;<code>S</code>，找出最长重复子串的长度。如果不存在重复子串就返回 <code>0</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>&quot;abcd&quot;
//<strong>输出：</strong>0
//<strong>解释：</strong>没有重复子串。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>&quot;abbaba&quot;
//<strong>输出：</strong>2
//<strong>解释：</strong>最长的重复子串为 &quot;ab&quot; 和 &quot;ba&quot;，每个出现 2 次。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>&quot;aabcaabdaab&quot;
//<strong>输出：</strong>3
//<strong>解释：</strong>最长的重复子串为 &quot;aab&quot;，出现 3 次。
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>&quot;aaaaa&quot;
//<strong>输出：</strong>4
//<strong>解释：</strong>最长的重复子串为 &quot;aaaa&quot;，出现 2 次。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>字符串&nbsp;<code>S</code>&nbsp;仅包含从&nbsp;<code>&#39;a&#39;</code> 到&nbsp;<code>&#39;z&#39;</code>&nbsp;的小写英文字母。</li>
//	<li><code>1 &lt;= S.length &lt;= 1500</code></li>
//</ol>
//<div><div>Related Topics</div><div><li>字符串</li><li>二分查找</li><li>动态规划</li><li>后缀数组</li><li>哈希函数</li><li>滚动哈希</li></div></div><br><div><li>👍 72</li><li>👎 0</li></div>
package leetcode.editor.cn;

import cn.hutool.core.lang.hash.Hash;

import java.util.HashSet;

// 1062:最长重复子串
public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestRepeatingSubstring(String s) {
            int left = 1;
            int right = s.length();
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (search(s, mid) != -1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left - 1;
        }

        private int search(String str, int length) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i <= str.length() - length; i++) {
                int hashCode = str.substring(i, i + length).hashCode();
                if (hashSet.contains(hashCode)) {
                    return hashCode;
                }
                hashSet.add(hashCode);
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
