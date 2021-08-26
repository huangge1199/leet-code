package study.plan.meituan.meituan004;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int length = sc.nextInt();
        int[] bArr = new int[length];
        Arrays.fill(bArr, -1);
        int[] aArr = sc.nextIntArr(length);
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int op = Integer.parseInt(sc.next());
            if (op == 2) {
                list.add(bArr[Integer.parseInt(sc.next()) - 1]);
            } else {
                int k = Integer.parseInt(sc.next());
                int x = Integer.parseInt(sc.next()) - 1;
                int y = Integer.parseInt(sc.next()) - 1;
//                System.arraycopy(aArr, x, bArr, y, k);
                for (int j = 0; j < k; j++) {
                    if (y >= bArr.length || x >= aArr.length) {
                        break;
                    }
                    bArr[y] = aArr[x];
                    x++;
                    y++;
                }
            }
        }
        for (Integer integer : list) {
            pw.println(integer);
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
