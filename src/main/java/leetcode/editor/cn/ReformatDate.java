//<p>给你一个字符串&nbsp;<code>date</code>&nbsp;，它的格式为&nbsp;<code>Day Month Year</code>&nbsp;，其中：</p>
//
//<ul>
//	<li><code>Day</code>&nbsp;是集合&nbsp;<code>{&quot;1st&quot;, &quot;2nd&quot;, &quot;3rd&quot;, &quot;4th&quot;, ..., &quot;30th&quot;, &quot;31st&quot;}</code>&nbsp;中的一个元素。</li>
//	<li><code>Month</code>&nbsp;是集合&nbsp;<code>{&quot;Jan&quot;, &quot;Feb&quot;, &quot;Mar&quot;, &quot;Apr&quot;, &quot;May&quot;, &quot;Jun&quot;, &quot;Jul&quot;, &quot;Aug&quot;, &quot;Sep&quot;, &quot;Oct&quot;, &quot;Nov&quot;, &quot;Dec&quot;}</code>&nbsp;中的一个元素。</li>
//	<li><code>Year</code>&nbsp;的范围在 ​<code>[1900, 2100]</code>&nbsp;之间。</li>
//</ul>
//
//<p>请你将字符串转变为&nbsp;<code>YYYY-MM-DD</code>&nbsp;的格式，其中：</p>
//
//<ul>
//	<li><code>YYYY</code>&nbsp;表示 4 位的年份。</li>
//	<li><code>MM</code>&nbsp;表示 2 位的月份。</li>
//	<li><code>DD</code>&nbsp;表示 2 位的天数。</li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>date = &quot;20th Oct 2052&quot;
//<strong>输出：</strong>&quot;2052-10-20&quot;
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>date = &quot;6th Jun 1933&quot;
//<strong>输出：</strong>&quot;1933-06-06&quot;
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>date = &quot;26th May 1960&quot;
//<strong>输出：</strong>&quot;1960-05-26&quot;
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>给定日期保证是合法的，所以不需要处理异常输入。</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

// 1507:转变日期格式
public class ReformatDate {
    public static void main(String[] args) {
        Solution solution = new ReformatDate().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformatDate(String date) {
            String[] strs = date.split(" ");
            List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
            int day = Integer.parseInt(strs[0].substring(0, strs[0].length() - 2));
            int month = months.indexOf(strs[1]) + 1;
            int year = Integer.parseInt(strs[2]);
            return String.format("%04d-%02d-%02d", year, month, day);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
