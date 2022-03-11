//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 53 👎 0

package leetcode.editor.cn;

import java.util.*;

//2049:统计最高分的节点数目
public class CountNodesWithTheHighestScore {
    public static void main(String[] args) {
        Solution solution = new CountNodesWithTheHighestScore().new Solution();
        // TO TEST
        solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 记录每一个节点作为根节点的子树中节点的数量
        int[] counts;

        public int countHighestScoreNodes(int[] parents) {
            int size = parents.length;

            // 记录每个节点的直接子节点
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 1; i < size; i++) {
                map.get(parents[i]).add(i);
            }

            // 记录每个子节点为根节点的树中节点数
            counts = new int[size];
            for (int i = 0; i < size; i++) {
                if (counts[i] > 0) {
                    continue;
                }
                counts[i] = dfs(map.get(i), map);
            }

            // 遍历计算每个节点的得分并统计结果
            long mul = 1;
            for (int num : map.get(0)) {
                mul *= counts[num];
            }
            int count = 1;
            for (int i = 1; i < size; i++) {
                long temp = 1;
                for (int num : map.get(i)) {
                    temp *= counts[num];
                }
                temp *= (size - counts[i]);
                if (temp > mul) {
                    mul = temp;
                    count = 1;
                } else if (temp == mul) {
                    count++;
                }
            }
            return count;
        }

        /**
         * 计算每个节点为根节点的树中节点数
         */
        private int dfs(List<Integer> list, Map<Integer, List<Integer>> map) {
            if (list.size() == 0) {
                return 1;
            }
            int count = 1;
            for (int i : list) {
                if (counts[i] > 0) {
                    count += counts[i];
                } else {
                    count += dfs(map.get(i), map);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
