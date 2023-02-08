//<p>你是一位系统管理员，手里有一份文件夹列表 <code>folder</code>，你的任务是要删除该列表中的所有 <strong>子文件夹</strong>，并以 <strong>任意顺序</strong> 返回剩下的文件夹。</p>
//
//<p>如果文件夹&nbsp;<code>folder[i]</code>&nbsp;位于另一个文件夹&nbsp;<code>folder[j]</code>&nbsp;下，那么&nbsp;<code>folder[i]</code>&nbsp;就是&nbsp;<code>folder[j]</code>&nbsp;的 <strong>子文件夹</strong> 。</p>
//
//<p>文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：<font color="#c7254e"><font face="Menlo, Monaco, Consolas, Courier New, monospace"><span style="font-size:12.6px"><span style="background-color:#f9f2f4">'/'</span></span></font></font>&nbsp;后跟一个或者多个小写英文字母。</p>
//
//<ul> 
// <li>例如，<code>"/leetcode"</code>&nbsp;和&nbsp;<code>"/leetcode/problems"</code>&nbsp;都是有效的路径，而空字符串和&nbsp;<code>"/"</code>&nbsp;不是。</li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//<strong>输出：</strong>["/a","/c/d","/c/f"]
//<strong>解释：</strong>"/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>folder = ["/a","/a/b/c","/a/b/d"]
//<strong>输出：</strong>["/a"]
//<strong>解释：</strong>文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入:</strong> folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//<strong>输出:</strong> ["/a/b/c","/a/b/ca","/a/b/d"]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= folder.length &lt;= 4 * 10<sup>4</sup></code></li> 
// <li><code>2 &lt;= folder[i].length &lt;= 100</code></li> 
// <li><code>folder[i]</code>&nbsp;只包含小写字母和 <code>'/'</code></li> 
// <li><code>folder[i]</code>&nbsp;总是以字符 <code>'/'</code>&nbsp;起始</li> 
// <li>每个文件夹名都是 <strong>唯一</strong> 的</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>字典树</li><li>数组</li><li>字符串</li></div></div><br><div><li>👍 112</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1233:删除子文件夹
public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            List<String> res = new ArrayList<>();
            Arrays.sort(folder);
            res.add(folder[0]);
            for (int i = 1; i < folder.length; i++) {
                if (!folder[i].startsWith(res.get(res.size() - 1) + "/")) {
                    res.add(folder[i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
