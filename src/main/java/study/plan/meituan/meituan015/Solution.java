package study.plan.meituan.meituan015;

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
        int n = sc.nextInt();
        int m = sc.nextInt();
        int xs = sc.nextInt();
        int ys = sc.nextInt();
        int xt = sc.nextInt();
        int yt = sc.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] b = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        int[] direction = new int[]{0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{xs, ys});
        boolean[][] use = new boolean[n + 1][m + 1];
        use[xs][ys] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                int[] cur = queue.poll();
                if (cur[0] == xt && cur[1] == yt) {
                    pw.println(time);
                    return;
                }
                for (int j = 0; j < direction.length; j++) {
                    int remainder = time % (a[cur[0]][cur[1]] + b[cur[0]][cur[1]]);
                    int x = cur[0], y = cur[1];
                    if (remainder < a[x][y]) {
                        x += direction[j];
                    } else {
                        y += direction[j];
                    }
                    if (x < 1 || x > n || y < 1 || y > m) {
                        continue;
                    }
                    if (!use[x][y] || j == 0) {
                        queue.offer(new int[]{x, y});
                        use[x][y] = true;
                    }
                }
            }
            time++;
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
