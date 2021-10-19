package contest.y2021.fall.term.contest2;

import com.code.leet.entiy.TwoArray;

import java.util.*;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/9/25-16:40
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TwoArray terrain = new TwoArray("[[5,0],[0,6]]", true);
        TwoArray obstacle = new TwoArray("[[0,6],[7,0]]", true);
        solution.bicycleYard(new int[]{1, 1}, terrain.getArr(), obstacle.getArr());
    }

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] px = new int[]{-1, 1, 0, 0};
        int[] py = new int[]{0, 0, -1, 1};
        queue.add(position);
        int[][] speeds = new int[terrain.length][terrain[0].length];
        for (int[] ints : speeds) {
            Arrays.fill(ints, -1);
        }
        speeds[position[0]][position[1]] = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int h1 = terrain[point[0]][point[1]];
            int cur = speeds[point[0]][point[1]];
            for (int i = 0; i < 4; i++) {
                int x = point[0] + px[i];
                int y = point[1] + py[i];
                if (x < 0 || x >= terrain.length || y < 0 || y >= terrain[0].length) {
                    continue;
                }
                int h2 = terrain[x][y];
                int o2 = obstacle[x][y];
                int speed = cur + h1 - h2 - o2;
                if (speed <= 0 || (speeds[x][y] > 0 && speed >= speeds[x][y])) {
                    continue;
                }
                if (speed == 1) {
                    result.add(new int[]{x, y});
                }
                speeds[x][y] = speed;
                queue.add(new int[]{x, y});
            }
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        Arrays.sort(ans, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return ans;
    }
}
