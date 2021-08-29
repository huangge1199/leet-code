package study.plan.meituan.meituan014;

import java.io.*;
import java.util.*;

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
        int x = sc.nextInt();
        int y = sc.nextInt();
        char[] chs = new char[x + y];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < x + y; i++) {
            int num = sc.nextInt();
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
            chs[i] = 'B';
        }
        if (y == x) {
            for (int i = 0; i < x; i++) {
                chs[i] = 'A';
            }
            pw.println(new String(chs));
        } else if (y < x) {
            int index = 0;
            for (int key : map.keySet()) {
                List<Integer> list = map.get(key);
                Collections.sort(list);
                for (Integer integer : list) {
                    chs[integer] = 'A';
                    index++;
                    if (index == x) {
                        pw.println(new String(chs));
                        return;
                    }
                }
            }
        } else {
            int index = 0;
            for (int key : map.keySet()) {
                List<Integer> list = map.get(key);
                list.sort(Collections.reverseOrder());
                for (Integer integer : list) {
                    index++;
                    if (index > y) {
                        chs[integer] = 'A';
                    }
                }
            }
            pw.println(new String(chs));
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
