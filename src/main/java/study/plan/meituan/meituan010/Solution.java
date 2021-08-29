package study.plan.meituan.meituan010;

import java.io.*;
import java.util.StringTokenizer;

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
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = sc.nextIntArr(n);
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int left = i, right = m + 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                boolean bl = true;
                int pre = -1;
                for (int x : arr) {
                    if (i > x || mid < x) {
                        if (x < pre) {
                            bl = false;
                            break;
                        }
                        pre = x;
                    }
                }
                if (bl) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            count += m - left + 1;
            if (left == m + 1) {
                break;
            }
        }
        pw.println(count);
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
