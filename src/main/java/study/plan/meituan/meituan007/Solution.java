package study.plan.meituan.meituan007;

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
        int size = sc.nextInt();
        boolean[] use = new boolean[size];
        for (int i = 0; i < size; i++) {
            int[] arr = sc.nextIntArr(size);
            for (int j = 0; j < size; j++) {
                if (!use[arr[j] - 1]) {
                    pw.print(arr[j] + " ");
                    use[arr[j] - 1] = true;
                    break;
                }
            }
        }
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
