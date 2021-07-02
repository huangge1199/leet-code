package leet.book.queueStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 10:53
 * @Description: No Description
 */
public class NumIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1'){
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }
        private void dfs(char[][] grid, int x, int y){
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            dfs(grid, x + 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x - 1, y);
            dfs(grid, x, y - 1);
        }
    }
}
