//<p>假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：</p>
//
//<p><img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mdir.jpg" style="height: 142px; width: 300px;" /></p>
//
//<p>这里将 <code>dir</code> 作为根目录中的唯一目录。<code>dir</code> 包含两个子目录 <code>subdir1</code> 和 <code>subdir2</code> 。<code>subdir1</code> 包含文件 <code>file1.ext</code> 和子目录 <code>subsubdir1</code>；<code>subdir2</code> 包含子目录 <code>subsubdir2</code>，该子目录下包含文件 <code>file2.ext</code> 。</p>
//
//<p>在文本格式中，如下所示(⟶表示制表符)：</p>
//
//<pre>
//dir
//⟶ subdir1
//⟶ ⟶ file1.ext
//⟶ ⟶ subsubdir1
//⟶ subdir2
//⟶ ⟶ subsubdir2
//⟶ ⟶ ⟶ file2.ext
//</pre>
//
//<p>如果是代码表示，上面的文件系统可以写为 <code>"dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext"</code> 。<code>'
//'</code> 和 <code>'\t'</code> 分别是换行符和制表符。</p>
//
//<p>文件系统中的每个文件和文件夹都有一个唯一的 <strong>绝对路径</strong> ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 <code>'/'</code> 连接。上面例子中，指向 <code>file2.ext</code> 的 <strong>绝对路径</strong> 是 <code>"dir/subdir2/subsubdir2/file2.ext"</code> 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 <code>name.extension</code> 的格式，其中<meta charset="UTF-8" />&nbsp;<code>name</code>&nbsp;和<meta charset="UTF-8" />&nbsp;<code>extension</code>由字母、数字和/或空格组成。</p>
//
//<p>给定一个以上述格式表示文件系统的字符串 <code>input</code> ，返回文件系统中&nbsp;<em>指向&nbsp;<strong>文件</strong>&nbsp;的 <strong>最长绝对路径</strong> 的长度</em>&nbsp;。 如果系统中没有文件，返回&nbsp;<code>0</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/dir1.jpg" style="height: 101px; width: 200px;" />
//<pre>
//<strong>输入：</strong>input = "dir
//\tsubdir1
//\tsubdir2
//\t\tfile.ext"
//<strong>输出：</strong>20
//<strong>解释：</strong>只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/dir2.jpg" style="height: 151px; width: 300px;" />
//<pre>
//<strong>输入：</strong>input = "dir
//\tsubdir1
//\t\tfile1.ext
//\t\tsubsubdir1
//\tsubdir2
//\t\tsubsubdir2
//\t\t\tfile2.ext"
//<strong>输出：</strong>32
//<strong>解释：</strong>存在两个文件：
//"dir/subdir1/file1.ext" ，路径长度 21
//"dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
//返回 32 ，因为这是最长的路径</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>input = "a"
//<strong>输出：</strong>0
//<strong>解释：</strong>不存在任何文件</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>input = "file1.txt
//file2.txt
//longfile.txt"
//<strong>输出：</strong>12
//<strong>解释：</strong>根目录下有 3 个文件。
//因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= input.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>input</code> 可能包含小写或大写的英文字母，一个换行符 <code>'
//'</code>，一个制表符 <code>'\t'</code>，一个点 <code>'.'</code>，一个空格 <code>' '</code>，和数字。</li>
//</ul>
//<div><div>Related Topics</div><div><li>栈</li><li>深度优先搜索</li><li>字符串</li></div></div><br><div><li>👍 188</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// 388:文件的最长绝对路径
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        Solution solution = new LongestAbsoluteFilePath().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String s) {
            Map<Integer, String> map = new HashMap<>();
            int n = s.length();
            String ans = null;
            for (int i = 0; i < n; ) {
                int level = 0;
                while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
                int j = i;
                boolean isDir = true;
                while (j < n && s.charAt(j) != '\n') {
                    if (s.charAt(j++) == '.') isDir = false;
                }
                String cur = s.substring(i, j);
                String prev = map.getOrDefault(level - 1, null);
                String path = prev == null ? cur : prev + "/" + cur;
                if (isDir) map.put(level, path);
                else if (ans == null || path.length() > ans.length()) ans = path;
                i = j + 1;
            }
            return ans == null ? 0 : ans.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
