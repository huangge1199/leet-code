package study.plan.meituan.meituan008;

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
        int t = sc.nextInt();
        int[][] mat = new int[n - 1][2];
        for (int i = 0; i < mat.length; i++) {
            mat[i] = sc.nextIntArr(2);
        }
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = mat[i][0];
            int y = mat[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }

        mdis = new int[n + 1];
        Arrays.fill(mdis, -1);
        tdis = new int[n + 1];
        Arrays.fill(tdis, -1);
        dism(m);
        dist(t);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (mdis[i] > tdis[i]) res = Math.max(res, mdis[i]);
        }
        pw.println(res);
    }

    static List<List<Integer>> list;
    static int[] mdis;
    static int[] tdis;

    public static void dism(int index) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(index);
        int t;
        mdis[index] = 0;
        while (!deque.isEmpty()) {
            t = deque.removeFirst();
            List<Integer> templist = list.get(t);
            for (int i = 0; i < templist.size(); i++) {
                if (mdis[templist.get(i)] == -1) {
                    mdis[templist.get(i)] = mdis[t] + 1;
                    deque.add(templist.get(i));
                }
            }
        }
    }

    public static void dist(int index) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(index);
        int t;
        tdis[index] = 0;
        while (!deque.isEmpty()) {
            t = deque.removeFirst();
            List<Integer> templist = list.get(t);
            for (int i = 0; i < templist.size(); i++) {
                if (tdis[templist.get(i)] == -1) {
                    tdis[templist.get(i)] = tdis[t] + 1;
                    deque.add(templist.get(i));
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
