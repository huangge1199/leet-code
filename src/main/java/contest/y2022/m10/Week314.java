package contest.y2022.m10;

/**
 * @author hyy
 * @Classname Week314
 * @Description TODO
 * @Date 2022/10/9 10:14
 */
public class Week314 {
    public static void main(String[] args) {
        Week314 solution = new Week314();
        String str = "zza";
        System.out.println(solution.robotWithString(str));
    }

    public int numberOfPaths(int[][] grid, int k) {
        long[][][] arrs = new long[grid.length][grid[0].length][k];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    arrs[i][j][grid[i][j] % k]++;
                    continue;
                }
                for (int l = 0; l < k; l++) {
                    int cnt = (int) (((long) grid[i][j] + l) % k);
                    if (i > 0) {
                        arrs[i][j][cnt] = (arrs[i][j][cnt] + arrs[i - 1][j][l]) % 1000000007;
                    }
                    if (j > 0) {
                        arrs[i][j][cnt] = (arrs[i][j][cnt] + arrs[i][j - 1][l]) % 1000000007;
                    }
                }
            }
        }
        return (int) arrs[grid.length - 1][grid[0].length - 1][0];
    }

    public String robotWithString(String s) {
        String str = "";
        String res = "";
        for (char i = 'a'; i <= 'z' && s.length() > 0; i++) {
            while (str.length() > 0 && str.charAt(str.length() - 1) <= i) {
                res += str.charAt(str.length() - 1);
                str = str.substring(0, str.length() - 1);
            }
            while (s.indexOf(i) >= 0) {
                res += i;
                int index = s.indexOf(i);
                str += s.substring(0, index);
                s = s.substring(index + 1);
            }
        }
        res += (new StringBuilder(str)).reverse().toString();
        return res;
    }

    public int[] findArray(int[] pref) {
        int size = pref.length;
        int[] res = new int[size];
        res[0] = pref[0];
        int xor = res[0];
        for (int i = 1; i < size; i++) {
            res[i] = xor ^ pref[i];
            xor = xor ^ res[i];
        }
        return res;
    }

    public int hardestWorker(int n, int[][] logs) {
        int min = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            if (min < logs[i][1] - logs[i - 1][1]) {
                min = logs[i][1] - logs[i - 1][1];
                id = logs[i][0];
            } else if (min == logs[i][1] - logs[i - 1][1]) {
                id = Math.min(id, logs[i][0]);
            }
        }
        return id;
    }
}
