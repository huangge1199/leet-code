//<p>你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 <code>m x n</code> 的矩阵表示， 在这个矩阵中：</p>
//
//<ul>
//	<li><code>0</code> 表示障碍，无法触碰</li>
//	<li><code>1</code> 表示地面，可以行走</li>
//	<li><code>比 1 大的数</code> 表示有树的单元格，可以行走，数值表示树的高度</li>
//</ul>
//
//<p>每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。</p>
//
//<p>你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 <code>1</code>（即变为地面）。</p>
//
//<p>你将从 <code>(0, 0)</code> 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 <code>-1</code> 。</p>
//
//<p>可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/trees1.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>输入：</strong>forest = [[1,2,3],[0,0,4],[7,6,5]]
//<strong>输出：</strong>6
//<strong>解释：</strong>沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/trees2.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>输入：</strong>forest = [[1,2,3],[0,0,0],[7,6,5]]
//<strong>输出：</strong>-1
//<strong>解释：</strong>由于中间一行被障碍阻塞，无法访问最下面一行中的树。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>forest = [[2,3,4],[0,0,5],[8,7,6]]
//<strong>输出：</strong>6
//<strong>解释：</strong>可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == forest.length</code></li>
//	<li><code>n == forest[i].length</code></li>
//	<li><code>1 <= m, n <= 50</code></li>
//	<li><code>0 <= forest[i][j] <= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>广度优先搜索</li><li>数组</li><li>矩阵</li><li>堆（优先队列）</li></div></div><br><div><li>👍 155</li><li>👎 0</li></div>
package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

// 675:为高尔夫比赛砍树
public class CutOffTreesForGolfEvent {
    public static void main(String[] args) {
        Solution solution = new CutOffTreesForGolfEvent().new Solution();
        // TO TEST
        List<List<Integer>> forest = Arrays.asList(
                Arrays.asList(54581641,64080174,24346381,69107959)
                , Arrays.asList(86374198,61363882,68783324,79706116)
                , Arrays.asList(668150,  92178815,89819108,94701471)
                , Arrays.asList(83920491,22724204,46281641,47531096)
                , Arrays.asList(89078499,18904913,25462145,60813308));
        solution.cutOffTree(forest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            /*
            起始位置不可到达的情况，即坐标（0,0）位置为0
             */
            if (forest.get(0).get(0) == 0) {
                return -1;
            }
            int xL = forest.size();
            int yL = forest.get(0).size();

            /*
            按照顺序排列需要砍的树，记录每棵树的位置
             */
            TreeMap<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
            for (int i = 0; i < xL; i++) {
                List<Integer> list = forest.get(i);
                for (int j = 0; j < yL; j++) {
                    if (list.get(j) > 1) {
                        map.put(list.get(j), new Pair<>(i, j));
                    }
                }
            }
            int step = 0;
            Pair<Integer, Integer> pair = null;
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(0, 0));
            boolean[][] uses = new boolean[xL][yL];
            uses[0][0] = true;
            int[] xs = new int[]{1, -1, 0, 0};
            int[] ys = new int[]{0, 0, 1, -1};
            for (int key : map.keySet()) {
                Pair<Integer, Integer> cur = map.get(key);
                if (queue.peek().equals(cur)) {
                    continue;
                }
                boolean bl = false;
                /*
                计算到达下一棵需要砍树的步数
                 */
                while (!queue.isEmpty() && !bl) {
                    int nums = queue.size();
                    step++;
                    for (int i = 0; i < nums && !bl; i++) {
                        Pair<Integer, Integer> tmp = queue.poll();
                        for (int j = 0; j < 4; j++) {
                            int x = tmp.getKey() + xs[j];
                            int y = tmp.getValue() + ys[j];
                            if (x == cur.getKey() && y == cur.getValue()) {
                                bl = true;
                                break;
                            }
                            if (x < 0 || x >= xL || y < 0 || y
                                    >= yL || uses[x][y] || forest.get(x).get(y) == 0) {
                                continue;
                            }
                            queue.add(new Pair<>(x, y));
                            uses[x][y] = true;
                        }
                    }
                }
                if (!bl) {
                    return -1;
                }
                queue = new LinkedList<>();
                queue.add(cur);
                uses = new boolean[xL][yL];
                uses[cur.getKey()][cur.getValue()] = true;
            }
            return step;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
