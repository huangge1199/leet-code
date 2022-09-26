//<p>系统中存在 <code>n</code> 个进程，形成一个有根树结构。给你两个整数数组 <code>pid</code> 和 <code>ppid</code> ，其中 <code>pid[i]</code> 是第 <code>i</code> 个进程的 ID ，<code>ppid[i]</code> 是第 <code>i</code> 个进程的父进程 ID 。</p>
//
//<p>每一个进程只有 <strong>一个父进程</strong> ，但是可能会有 <strong>一个或者多个子进程</strong> 。只有一个进程的 <code>ppid[i] = 0</code> ，意味着这个进程 <strong>没有父进程</strong> 。</p>
//
//<p>当一个进程 <strong>被杀掉</strong> 的时候，它所有的子进程和后代进程都要被杀掉。</p>
//
//<p>给你一个整数 <code>kill</code> 表示要杀掉​​进程的 ID ，返回杀掉该进程后的所有进程 ID 的列表。可以按 <strong>任意顺序</strong> 返回答案。</p>
// 
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/24/ptree.jpg" style="width: 207px; height: 302px;" />
//<pre>
//<strong>输入：</strong>pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
//<strong>输出：</strong>[5,10]
//<strong>解释：</strong>涂为红色的进程是应该被杀掉的进程。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>pid = [1], ppid = [0], kill = 1
//<strong>输出：</strong>[1]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>n == pid.length</code></li>
//	<li><code>n == ppid.length</code></li>
//	<li><code>1 <= n <= 5 * 10<sup>4</sup></code></li>
//	<li><code>1 <= pid[i] <= 5 * 10<sup>4</sup></code></li>
//	<li><code>0 <= ppid[i] <= 5 * 10<sup>4</sup></code></li>
//	<li>仅有一个进程没有父进程</li>
//	<li><code>pid</code> 中的所有值 <strong>互不相同</strong></li>
//	<li>题目数据保证 <code>kill</code> 在 <code>pid</code> 中</li>
//</ul>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>广度优先搜索</li><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 87</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.*;

// 582:杀掉进程
public class KillProcess {
    public static void main(String[] args) {
        Solution solution = new KillProcess().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (Integer integer : pid) {
                map.put(integer, new ArrayList<>());
            }
            map.put(0, new ArrayList<>());
            for (int i = 0; i < ppid.size(); i++) {
                map.get(ppid.get(i)).add(pid.get(i));
            }
            List<Integer> result = new ArrayList<>();
            result.add(kill);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(kill);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int key = queue.poll();
                    List<Integer> tmps = map.get(key);
                    for (int tmp : tmps) {
                        result.add(tmp);
                        queue.add(tmp);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
