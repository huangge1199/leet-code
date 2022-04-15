//<p>给你长度相等的两个字符串 <code>s1</code> 和 <code>s2</code> 。一次<strong> 字符串交换 </strong>操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。</p>
//
//<p>如果对 <strong>其中一个字符串</strong> 执行 <strong>最多一次字符串交换</strong> 就可以使两个字符串相等，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>s1 = "bank", s2 = "kanb"
//<strong>输出：</strong>true
//<strong>解释：</strong>例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>s1 = "attack", s2 = "defend"
//<strong>输出：</strong>false
//<strong>解释：</strong>一次字符串交换无法使两个字符串相等
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>s1 = "kelb", s2 = "kelb"
//<strong>输出：</strong>true
//<strong>解释：</strong>两个字符串已经相等，所以不需要进行字符串交换
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>s1 = "abcd", s2 = "dcba"
//<strong>输出：</strong>false
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s1.length, s2.length &lt;= 100</code></li>
//	<li><code>s1.length == s2.length</code></li>
//	<li><code>s1</code> 和 <code>s2</code> 仅由小写英文字母组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>计数</li></div></div><br><div><li>👍 29</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Classname ${NAME}
 * Description 1790:仅执行一次字符串交换能否使两个字符串相等
 * Date ${DATE} ${TIME}
 * author ${USER}
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        Solution solution = new CheckIfOneStringSwapCanMakeStringsEqual().new Solution();
        // TO TEST
        System.out.println(solution.areAlmostEqual("bank", "kanb"));
        System.out.println(solution.areAlmostEqual("attack", "defend"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (list.size() == 1) {
                        int index = list.get(0);
                        s1 = s1.substring(0, index)
                                + s1.charAt(i)
                                + s1.substring(index + 1, i)
                                + s1.charAt(index)
                                + s1.substring(i + 1);
                        return s1.equals(s2);
                    }
                    list.add(i);
                }
            }
            return list.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
