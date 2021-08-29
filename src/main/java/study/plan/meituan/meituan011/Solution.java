package study.plan.meituan.meituan011;

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    static Scanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    public static void solve() throws IOException {
        int[] counts = sc.nextIntArr(4);
        int[] prices = sc.nextIntArr(3);
        int max = 0;
        int min = 0;
        for (int i = 1; i < 3; i++) {
            if (prices[i] > prices[max]) {
                max = i;
            } else if (prices[i] < prices[min]) {
                min = i;
            }
        }
        int mid = 0;
        for (int i = 0; i < 3; i++) {
            if (i != max && i != min) {
                mid = i;
            }
        }
        int count = Math.min(counts[max], counts[3]);
        long sum = (long) count * prices[max];
        counts[3] -= count;
        if (counts[3] > 0) {
            count = Math.min(counts[mid], counts[3]);
            sum += (long) count * prices[mid];
        }
        counts[3] -= count;
        if (counts[3] > 0) {
            count = Math.min(counts[min], counts[3]);
            sum += (long) count * prices[min];
        }
        pw.println(sum);
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
