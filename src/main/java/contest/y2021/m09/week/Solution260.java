package contest.y2021.m09.week;


import com.code.leet.entiy.TwoArray;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution260 {
    public static void main(String[] args) {
        Solution260 solution = new Solution260();
        TwoArray twoArray = new TwoArray("[[1,3,1,15],[1,3,3,1]]", true);
        solution.gridGame(twoArray.getArr());
    }

    public int maximumDifference(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j] - nums[i]);
            }
        }
        return max > 0 ? max : -1;
    }

    public long gridGame(int[][] grid) {
        int size = grid[0].length;
        long[][] sums = new long[2][size + 1];
        for (int i = 0; i < size; i++) {
            sums[0][i + 1] = sums[0][i] + grid[0][i];
            sums[1][i + 1] = sums[1][i] + grid[1][i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 1; i < size + 1; i++) {
            min = Math.min(min, Math.max(sums[0][size] - sums[0][i], sums[1][0] - sums[1][i - 1]));
        }
        return min;
    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        int size = word.length();
        for (int i = 0; i < board.length; i++) {
            int blank = 0;
            boolean add = false;
            for (int j = 0; j < board[0].length; j++) {
                if (size - blank > board[0].length - j) {
                    break;
                }
                if (board[i][j] == ' ' && add) {
                    blank++;
                } else if (board[i][j] == ' ' && !add && ((j > 1 && board[i][j - 1] == '#') || j == 0)) {
                    if (blank == size) {
                        return true;
                    }
                    add = true;
                    blank = 0;
                } else if (board[i][j] != ' ' && board[i][j] != '#') {
                    if(word.contains(""+board[i][j])){
                        String temp = word;
                        int index = temp.indexOf(""+board[i][j]);
                        if(blank==index){
                            blank++;
                        }
                    }
                } else {
                    add = false;
                }
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            int blank = 0;
            boolean add = false;
            for (int j = 0; j < board.length; j++) {
                if (size - blank > board.length - j) {
                    break;
                }
                if (board[j][i] == ' ' && add) {
                    blank++;
                } else if (board[j][i] == ' ' && !add && ((i > 1 && board[j][i - 1] == '#') || i == 0)) {
                    if (blank == size) {
                        return true;
                    }
                    add = true;
                    blank = 0;
                } else {
                    add = false;
                }
            }
        }
        return false;
    }
}
