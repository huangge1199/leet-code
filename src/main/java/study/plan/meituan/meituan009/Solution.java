package study.plan.meituan.meituan009;

import java.io.*;
import java.util.*;

public class Solution {

    static Scanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    public static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            f[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k += j) {
                    f[i][k] = (f[i][k] + f[i - 1][j]) % 998244353;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            res = (res + f[m][i]) % 998244353;
        }
        pw.println(res);
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader f) {
            br = new BufferedReader(f);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(next());
            }
            return arr;
        }

    }
}
