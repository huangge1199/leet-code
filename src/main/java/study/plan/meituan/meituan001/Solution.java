package study.plan.meituan.meituan001;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author huangge1199
 * @Date 2021/8/23 15:21
 **/
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
        int num = sc.nextInt();
        while (num-- > 0) {
            String username = sc.next();
            if (username.length() == 0) {
                pw.println("Wrong");
                continue;
            }
            if (!Character.isLetter(username.charAt(0))) {
                pw.println("Wrong");
                continue;
            }
            boolean[] flag = new boolean[2];
            boolean wrong = false;
            for (int i = 0; i < username.length() && !wrong; i++) {
                if (Character.isLetter(username.charAt(i))) {
                    flag[0] = true;
                } else if (Character.isDigit(username.charAt(i))) {
                    flag[1] = true;
                } else {
                    wrong = true;
                    break;
                }
            }
            if(!(flag[0]&&flag[1])){
                pw.println("Wrong");
                continue;
            }
            if(wrong){
                pw.println("Wrong");
            }else{
                pw.println("Accept");
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
