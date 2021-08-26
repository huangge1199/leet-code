package study.plan.meituan.meituan003;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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
        int sum = Integer.parseInt(sc.next());
        int num = Integer.parseInt(sc.next());
        int[][] arrs = new int[sum][2];
        for (int i = 0; i < sum; i++) {
            arrs[i][0] = i + 1;
            int v = Integer.parseInt(sc.next());
            int w = Integer.parseInt(sc.next());
            arrs[i][1] = v + 2 * w;
        }
        Arrays.sort(arrs, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int[] result = new int[num];
        for (int i = 1; i <= num; i++) {
            result[i - 1] = arrs[sum - i][0];
        }
        Arrays.sort(result);
        for (int i = 0; i < num; i++) {
            pw.print(result[i] + " ");
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
