package study.plan.meituan.meituan006;

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
        int size = sc.nextInt();
        String str = sc.next();
        int start = str.indexOf("M") + 1;
        int end = str.lastIndexOf("T") - 1;
        while (start < end) {
            if(str.charAt(start)=='T'&&str.charAt(end)=='M'){
                pw.println(str.substring(start+1,end));
                return;
            }
            if(str.charAt(start)!='T'){
                start++;
            }
            if(str.charAt(end)!='M'){
                end--;
            }
        }
        pw.println("");
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
