//你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值： 
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1]
//,[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[-1]]
//输出：[[-1]]
// 
//
// 示例 3： 
//
// 
//输入：rooms = [[2147483647]]
//输出：[[2147483647]]
// 
//
// 示例 4： 
//
// 
//输入：rooms = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示： 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] 是 -1、0 或 231 - 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 154 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//286:墙与门
public class WallsAndGates {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new WallsAndGates().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int EMPTY = Integer.MAX_VALUE;
        private static final int GATE = 0;
        private final List<int[]> DIRECTIONS = Arrays.asList(
                new int[]{1, 0},
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{0, -1}
        );

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            if (m == 0) {
                return;
            }
            int n = rooms[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (rooms[row][col] == GATE) {
                        q.add(new int[]{row, col});
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][col] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}