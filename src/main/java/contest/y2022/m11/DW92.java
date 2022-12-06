package contest.y2022.m11;

public class DW92 {
    public static void main(String[] args) {
        DW92 solution = new DW92();
        System.out.println(solution.bestClosingTime("YYNY"));
    }

    public int countPalindromes(String s) {
        int size = s.length();
        int[][] arrl = new int[size][10];
        int[][] arrr = new int[size][10];
        long[][] al = new long[size][100];
        long[][] ar = new long[size][100];
        int mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                for (int j = 0; j < 10; j++) {
                    arrl[i][j] += arrl[i - 1][j];
                    arrr[s.length() - 1 - i][j] += arrr[s.length() - i][j];
                }
            }
            if (i < s.length() - 1) {
                arrl[i + 1][s.charAt(i - 1) - '0']++;
                arrr[s.length() - 2 - i][s.charAt(s.length() - i) - '0']++;
            }
            if (i > 1) {
                for (int j = 0; j < 100; j++) {
                    ar[i][j] = ar[i - 1][j];
                    ar[s.length() - 1 - i][j] = ar[s.length() - i][j];
                }
            }
            if (i < s.length() - 1) {
                int num = s.charAt(i - 1) - '0';
                for (int j = 0; j < 10; j++) {
                    al[i + 1][num * 10 + j] += arrl[i][j];
                    ar[s.length() - 2 - i][j * 10 + num] += arrr[i][j];
                }
            }
        }
        long res = 0;
        for (int i = 2; i < s.length() - 2; i++) {
            for (int j = 0; j < 100; j++) {
                res = (Math.min(al[i][j], ar[i][j]) + res) % mod;
            }
        }
        return (int) res;
    }

    public int bestClosingTime(String customers) {
        int[] arry = new int[customers.length() + 1];
        int[] arrn = new int[customers.length() + 1];
        for (int i = 0; i < customers.length(); i++) {
            arrn[i + 1] = arrn[i] + (customers.charAt(i) == 'N' ? 1 : 0);
            arry[customers.length() - i - 1] = arry[customers.length() - i] + (customers.charAt(customers.length() - i - 1) == 'Y' ? 1 : 0);
        }
        int min = arrn[0] + arry[0];
        int res = 0;
        for (int i = 1; i < customers.length() + 1; i++) {
            int tmp = arrn[i] + arry[i];
            if (min > tmp) {
                min = tmp;
                res = i;
            }
        }
        return res;
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int xl = grid.length;
        int yl = grid[0].length;
        int[] x0 = new int[xl];
        int[] y0 = new int[yl];
        int[] x1 = new int[xl];
        int[] y1 = new int[yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                if (grid[i][j] == 0) {
                    x0[i]++;
                    y0[j]++;
                }
                if (grid[i][j] == 1) {
                    x1[i]++;
                    y1[j]++;
                }
            }
        }
        int[][] diff = new int[xl][yl];
        for (int i = 0; i < xl; i++) {
            for (int j = 0; j < yl; j++) {
                diff[i][j] = x1[i] + y1[j] - x0[i] - y0[j];
            }
        }
        return diff;
    }

    public int numberOfCuts(int n) {
        return n % 2 == 0 ? n / 2 : n;
    }
}
