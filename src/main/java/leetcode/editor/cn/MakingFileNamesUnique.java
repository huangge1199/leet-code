//<p>给你一个长度为 <code>n</code> 的字符串数组 <code>names</code> 。你将会在文件系统中创建 <code>n</code> 个文件夹：在第 <code>i</code> 分钟，新建名为 <code>names[i]</code> 的文件夹。</p>
//
//<p>由于两个文件 <strong>不能</strong> 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 <code>(k)</code> 的形式为新文件夹的文件名添加后缀，其中 <code>k</code> 是能保证文件名唯一的 <strong>最小正整数</strong> 。</p>
//
//<p>返回长度为<em> <code>n</code></em> 的字符串数组，其中 <code>ans[i]</code> 是创建第 <code>i</code> 个文件夹时系统分配给该文件夹的实际名称。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>names = ["pes","fifa","gta","pes(2019)"]
//<strong>输出：</strong>["pes","fifa","gta","pes(2019)"]
//<strong>解释：</strong>文件系统将会这样创建文件名：
//"pes" --&gt; 之前未分配，仍为 "pes"
//"fifa" --&gt; 之前未分配，仍为 "fifa"
//"gta" --&gt; 之前未分配，仍为 "gta"
//"pes(2019)" --&gt; 之前未分配，仍为 "pes(2019)"
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>names = ["gta","gta(1)","gta","avalon"]
//<strong>输出：</strong>["gta","gta(1)","gta(2)","avalon"]
//<strong>解释：</strong>文件系统将会这样创建文件名：
//"gta" --&gt; 之前未分配，仍为 "gta"
//"gta(1)" --&gt; 之前未分配，仍为 "gta(1)"
//"gta" --&gt; 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)" 。
//"avalon" --&gt; 之前未分配，仍为 "avalon"
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
//<strong>输出：</strong>["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
//<strong>解释：</strong>当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>names = ["wano","wano","wano","wano"]
//<strong>输出：</strong>["wano","wano(1)","wano(2)","wano(3)"]
//<strong>解释：</strong>每次创建文件夹 "wano" 时，只需增加后缀中 k 的值即可。</pre>
//
//<p><strong>示例 5：</strong></p>
//
//<pre><strong>输入：</strong>names = ["kaido","kaido(1)","kaido","kaido(1)"]
//<strong>输出：</strong>["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
//<strong>解释：</strong>注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= names.length &lt;= 5 * 10^4</code></li> 
// <li><code>1 &lt;= names[i].length &lt;= 20</code></li> 
// <li><code>names[i]</code> 由小写英文字母、数字和/或圆括号组成。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 73</li><li>👎 0</li></div>
package leetcode.editor.cn;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

// 1487:保证文件名唯一
public class MakingFileNamesUnique {
    public static void main(String[] args) {
        Solution solution = new MakingFileNamesUnique().new Solution();
        // TO TEST
        solution.getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < names.length; ++i) {
                if (map.containsKey(names[i])) {
                    int cnt = map.get(names[i]);
                    while (map.containsKey(names[i] + "(" + cnt + ")")) {
                        cnt++;
                    }
                    map.put(names[i], cnt);
                    names[i] += "(" + cnt + ")";
                }
                map.put(names[i], 1);
            }
            return names;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
