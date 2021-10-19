package contest.y2021.m06.dw;

public class SolutionD54 {
    public static void main(String[] args) {
        SolutionD54 solution = new SolutionD54();
//        System.out.println(solution.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
//        System.out.println(solution.chalkReplacer(new int[]{3, 4, 1, 2}, 25));
        System.out.println(solution.largestMagicSquare(new int[][]{{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}}));
        System.out.println(solution.largestMagicSquare(new int[][]{{8,1,6}, {3,5,7}, {4,9,2}, {7,10,9}}));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean is = true;
            for (int[] range : ranges) {
                if (range[0] <= i && range[1] >= i) {
                    if (range[1] >= right) {
                        return true;
                    }
                    i = range[1];
                    is = false;
                    break;
                }
            }
            if (is) {
                return false;
            }
        }
        return false;
    }

    public int chalkReplacer(int[] chalk, int k) {
        int temp = k;
        int length = chalk.length;
        int[] free = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                free[i] = chalk[i];
            } else {
                free[i] += chalk[i] + free[i - 1];
            }
            temp -= chalk[i];
            if (temp < 0) {
                return i;
            }
        }
        temp %= free[length - 1];
        if (temp == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            temp -= chalk[i];
            if (temp < 0) {
                return i;
            }
        }
        return 0;
    }

    public int largestMagicSquare(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] xArr = new int[x][y + 1];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                xArr[i][j + 1] = xArr[i][j] + grid[i][j];
            }
        }
        int result = 1;
        //下面的前2层for是y的范围
        for (int i = 0; i <= y; i++) {
            for (int j = y; j > i + result; j--) {
                int sum = xArr[0][j] - xArr[0][i];
                int count = j - i;
                int temp = 1;
                int index = 0;
                //k
                for (int k = 1; k < x; k++) {
                    if (xArr[k][j] - xArr[k][i] == sum) {
                        temp++;
                    } else {
                        sum = xArr[k][j] - xArr[k][i];
                        temp = 1;
                        index = k;
                    }
                    if (temp == count) {
                        int x1 = 0;
                        int x2 = 0;
                        int m = 0;
                        for (int l = i; l < j; l++) {
                            x1 += grid[index + m][l];
                            x2 += grid[k - m][l];
                        }
                        if (sum == x1 && sum == x2) {
                            result = Math.max(result, count);
                            break;
                        }
                        index++;
                        temp--;
                    }
                }
            }
        }
        return result;
    }
}
