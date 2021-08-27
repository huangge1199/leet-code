package study.plan.meituan.meituan005;

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
        int k = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            List<Integer> list = map.getOrDefault(num1, new ArrayList<>());
            list.add(num2);
            map.put(num1, new ArrayList<>(list));
            list = map.getOrDefault(num2, new ArrayList<>());
            list.add(num1);
            map.put(num2, new ArrayList<>(list));
        }
        int[] level = sc.nextIntArr(n);
        long count = 0;
        boolean[] use = new boolean[n];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(use, false);
            count = (count + dfs(i, i, use, map, level, k)) % 1000000007;
        }
        pw.println(count);
    }

    private static long dfs(int num1, int num2, boolean[] use, Map<Integer, List<Integer>> map, int[] level, int k) {
        use[num1 - 1] = true;
        long count = 1;
        for (int num : map.get(num1)) {
            if (use[num - 1]) {
                continue;
            }
            boolean bl = level[num - 1] > level[num2 - 1] && level[num - 1] - level[num2 - 1] <= k
                    || level[num - 1] == level[num2 - 1] && num > num2;
            if (bl) {
                count = count * (1 + dfs(num, num2, use, map, level, k)) % 1000000007;
            }
        }
        return count;
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
