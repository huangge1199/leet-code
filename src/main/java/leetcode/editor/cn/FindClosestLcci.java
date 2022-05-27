//<p>有个内含单词的超大文本文件，给定任意两个<code>不同的</code>单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?</p>
//
//<p><strong>示例：</strong></p>
//
//<pre>
//<strong>输入：</strong>words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
//<strong>输出：</strong>1</pre>
//
//<p>提示：</p>
//
//<ul>
//	<li><code>words.length &lt;= 100000</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 50</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 面试题 17.11:单词距离
public class FindClosestLcci {
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    list1.add(i);
                }
                if (word2.equals(words[i])) {
                    list2.add(i);
                }
            }
            int index1 = 0;
            int index2 = 0;
            int min = words.length;
            while (index1 < list1.size() && index2 < list2.size()) {
                int num1 = list1.get(index1);
                int num2 = list2.get(index2);
                if (num1 < num2) {
                    min = Math.min(min, num2 - num1);
                    index1++;
                } else {
                    min = Math.min(min, num1 - num2);
                    index2++;
                }
                if (min == 1) {
                    return 1;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
