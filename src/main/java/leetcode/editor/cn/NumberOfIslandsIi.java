//给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有
//单元格都是 0）。 
//
// 可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是
//要执行第 i 次操作的位置 (ri, ci) 。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。 
//
// 岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。 
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//输出：[1,1,2,3]
//解释：
//起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
//- 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。此时存在 2 个岛屿。
//- 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。此时存在 3 个岛屿。
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 1, positions = [[0,0]]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n, positions.length <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度 O(k log(mn)) 的算法解决此问题吗？（其中 k == positions.length） 
// Related Topics 并查集 数组 👍 122 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//305:岛屿数量 II
public class NumberOfIslandsIi {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslandsIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean G(int x, int m, int y, int n) {
            return 0 <= x && x < m && 0 <= y && y < n;
        }

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            Union set = new Union(m * n);
            int[] vis = new int[m * n];
            List<Integer> ans = new ArrayList<>();
            for (int[] p : positions) {
                int i = n * p[0] + p[1], nx = p[0], ny = p[1], x = 0, y = 0;
                if (vis[i] == 1) {
                    ans.add(set.Count);
                    continue;
                }
                set.Count++;
                vis[i] = 1;
                x = nx;
                y = ny + 1;
                if (G(x, m, y, n) && vis[i + 1] == 1 && !set.united(i, i + 1)) set.union(i, i + 1);
                x = nx;
                y = ny - 1;
                if (G(x, m, y, n) && vis[i - 1] == 1 && !set.united(i, i - 1)) set.union(i, i - 1);
                x = nx + 1;
                y = ny;
                if (G(x, m, y, n) && vis[i + n] == 1 && !set.united(i, i + n)) set.union(i, i + n);
                x = nx - 1;
                y = ny;
                if (G(x, m, y, n) && vis[i - n] == 1 && !set.united(i, i - n)) set.union(i, i - n);
                ans.add(set.Count);
            }
            return ans;
        }
    }

    class Union {// 并查集模板
        int[] fa;
        int[] sz;
        public int Count;// 当前连通分量数目

        public boolean united(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }

        public int find(int x) {
            return fa[x] == x ? x : (fa[x] = find(fa[x]));
        }

        public Union(int n) {//构造函数+初始化
            this.sz = new int[n];
            for (int i = 0; i < n; i++) sz[i] = 1;
            this.fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            this.Count = 0;
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (sz[x] < sz[y]) {
                x ^= y;
                y ^= x;
                x ^= y;
            }//按秩合并保证 sz[x]>=sz[y]
            sz[x] += sz[y];
            fa[y] = x;
            --Count;//把秩小的unite到大的上
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}