package study.plan.meituan.meituan002;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author huangge1199
 * @Date 2021/8/23 15:39
 **/

class Solution {

    static Solution.Scanner sc;
    static PrintWriter pw;

    public static void main(String[] args) throws IOException {
        sc = new Solution.Scanner(System.in);
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    public static void solve() throws IOException {
        int num = sc.nextInt();
        int index = 0;
        int[] sums = new int[num];
        while (index < num) {
            sums[index] = index == 0 ? sc.nextInt() : sums[index - 1] + sc.nextInt();
            index++;
        }
        index = 0;
        while (index < num) {
            int remove = sc.nextInt();
            for (int i = remove; i < num; i++) {
                sums[i] -= sums[remove - 1];
            }
            sums[remove - 1] = 0;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < num; i++) {
                max = Math.max(max,sums[i]);
            }
            pw.println(max);
            index++;
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
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
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

