package leet.book.queueStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 14:14
 * @Description: No Description
 */
public class FloodFill {

    public static void main(String[] args) {
        Solution solution = new FloodFill().new Solution();
//        int[][] image = solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        int[][] image = solution.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1);
        System.out.println();
    }

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor != newColor) {
                fill(image, sr, sc, newColor, oldColor);
            }
            return image;
        }

        private void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
                return;
            }
            image[sr][sc] = newColor;
            fill(image, sr - 1, sc, newColor, oldColor);
            fill(image, sr + 1, sc, newColor, oldColor);
            fill(image, sr, sc - 1, newColor, oldColor);
            fill(image, sr, sc + 1, newColor, oldColor);
        }
    }

}
