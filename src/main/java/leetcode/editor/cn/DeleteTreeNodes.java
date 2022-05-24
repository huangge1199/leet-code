//<p>给你一棵以节点 0 为根节点的树，定义如下：</p>
//
//<ul>
//	<li>节点的总数为&nbsp;<code>nodes</code>&nbsp;个；</li>
//	<li>第&nbsp;<code>i</code> 个节点的值为&nbsp;<code>value[i]</code>&nbsp;；</li>
//	<li>第&nbsp;<code>i</code> 个节点的父节点是&nbsp;<code>parent[i]</code>&nbsp;。</li>
//</ul>
//
//<p>请你删除节点值之和为 0 的每一棵子树。</p>
//
//<p>在完成所有删除之后，返回树中剩余节点的数目。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/11/30/1421_sample_1.png" style="height: 347px; width: 403px;"></p>
//
//<pre><strong>输入：</strong>nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]
//<strong>输出：</strong>6
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>nodes = 5, parent = [-1,0,1,0,0], value = [-672,441,18,728,378]
//<strong>输出：</strong>5
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre><strong>输入：</strong>nodes = 5, parent = [-1,0,0,1,1], value = [-686,-842,616,-739,-746]
//<strong>输出：</strong>5
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nodes &lt;= 10^4</code></li>
//	<li><code>parent.length == nodes</code></li>
//	<li><code>0 &lt;= parent[i] &lt;= nodes - 1</code></li>
//	<li><code>parent[0] == -1</code>&nbsp;表示节点 <code>0</code> 是树的根。</li>
//	<li><code>value.length == nodes</code></li>
//	<li><code>-10^5 &lt;= value[i] &lt;= 10^5</code></li>
//	<li>题目输入数据 <strong>保证</strong> 是一棵 <strong>有效的树</strong> 。</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li></div></div><br><div><li>👍 32</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 1273:删除树节点
public class DeleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new DeleteTreeNodes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                lists.add(new ArrayList<>());
            }
            int head = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == -1) {
                    head = i;
                    continue;
                }
                lists.get(parent[i]).add(i);
            }
            int[] tmp = dfs(lists, head, value);
            return tmp[0] == 0 ? 0 : tmp[1];
        }

        private int[] dfs(List<List<Integer>> lists, int index, int[] value) {
            int[] cur = new int[]{value[index], 1};
            List<Integer> list = lists.get(index);
            int size = list.size();
            if (size == 0) {
                return cur;
            }
            for (Integer indx : list) {
                int[] tmp = dfs(lists, indx, value);
                if (tmp[0] != 0) {
                    cur[0] += tmp[0];
                    cur[1] += tmp[1];
                }
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
