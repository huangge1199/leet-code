//<p>给你一个字符串 <code>s</code> ，请你反转字符串中 <strong>单词</strong> 的顺序。</p>
//
//<p><strong>单词</strong> 是由非空格字符组成的字符串。<code>s</code> 中使用至少一个空格将字符串中的 <strong>单词</strong> 分隔开。</p>
//
//<p>返回 <strong>单词</strong> 顺序颠倒且 <strong>单词</strong> 之间用单个空格连接的结果字符串。</p>
//
//<p><strong>注意：</strong>输入字符串 <code>s</code>中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "<span><code>the sky is blue</code></span>"
//<strong>输出：</strong>"<span><code>blue is sky the</code></span>"
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = " &nbsp;hello world &nbsp;"
//<strong>输出：</strong>"world hello"
//<strong>解释：</strong>反转后的字符串中不能存在前导空格和尾随空格。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "a good &nbsp; example"
//<strong>输出：</strong>"example good a"
//<strong>解释：</strong>如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>s</code> 包含英文大小写字母、数字和空格 <code>' '</code></li> 
// <li><code>s</code> 中 <strong>至少存在一个</strong> 单词</li> 
//</ul>
//
//<ul> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong>如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用&nbsp;<code>O(1)</code> 额外空间复杂度的 <strong>原地</strong> 解法。</p>
//
//<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 703</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 151:反转字符串中的单词
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        // TO TEST
        System.out.println(solution.reverseWords("  hello world  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            while (s.contains("  ")) {
                s = s.replace("  ", " ");
            }
            if (s.charAt(0) == ' ') {
                s = s.substring(1);
            }
            if (s.charAt(s.length() - 1) == ' ') {
                s = s.substring(0, s.length() - 1);
            }
            String[] strs = s.split(" ");
            s = "";
            for (int i = strs.length - 1; i >= 0; i--) {
                s += strs[i] + " ";
            }
            return s.substring(0, s.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
