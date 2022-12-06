//<p>给你一个字符串 <code>word</code> ，该字符串由数字和小写英文字母组成。</p>
//
//<p>请你用空格替换每个不是数字的字符。例如，<code>"a123bc34d8ef34"</code> 将会变成 <code>" 123&nbsp; 34 8&nbsp; 34"</code> 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）：<code>"123"</code>、<code>"34"</code>、<code>"8"</code> 和 <code>"34"</code> 。</p>
//
//<p>返回对 <code>word</code> 完成替换后形成的 <strong>不同</strong> 整数的数目。</p>
//
//<p>只有当两个整数的 <strong>不含前导零</strong> 的十进制表示不同， 才认为这两个整数也不同。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>word = "a<strong>123</strong>bc<strong>34</strong>d<strong>8</strong>ef<strong>34</strong>"
//<strong>输出：</strong>3
//<strong>解释：</strong>不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>word = "leet<strong>1234</strong>code<strong>234</strong>"
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>word = "a<strong>1</strong>b<strong>01</strong>c<strong>001</strong>"
//<strong>输出：</strong>1
//<strong>解释：</strong>"1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= word.length &lt;= 1000</code></li> 
// <li><code>word</code> 由数字和小写英文字母组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 38</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;

// 1805:字符串中不同整数的数目
public class NumberOfDifferentIntegersInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfDifferentIntegersInAString().new Solution();
        // TO TEST
        System.out.println(solution.numDifferentIntegers("a123bc34d8ef34"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDifferentIntegers(String word) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                    word = word.replace(word.charAt(i) + "", " ");
                }
            }
            while (word.contains("  ")) {
                word = word.replace("  ", " ");
            }
            if (word.startsWith(" ")) {
                word = word.substring(1);
            }
            if (word.endsWith(" ")) {
                word = word.substring(0, word.length() - 1);
            }
            if (word.equals("")) {
                return 0;
            }
            String[] strs = word.split(" ");
            for (int i = 0; i < strs.length; i++) {
                while (strs[i].startsWith("0")) {
                    strs[i] = strs[i].substring(1);
                }
            }
            Arrays.sort(strs);
            int count = 1;
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i - 1].equals(strs[i])) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
