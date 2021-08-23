package study.plan.meituan;

import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    public static void solve() throws IOException {
        int T = sc.nextInt();
        while(T-- > 0){
            String s = sc.next();
            if(s.length() == 0){
                pw.println("Wrong");
                continue;
            }
            if(!Character.isLetter(s.charAt(0))){
                pw.println("Wrong");
                continue;
            }

            boolean flag = true;
            boolean hasLetter = false;
            boolean hasDigit = false;
            for (int i = 0; i < s.length(); i++) {
                if(!(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))){
                    flag = false;
                    break;
                }
                if(Character.isLetter(s.charAt(i))){
                    hasLetter = true;
                }
                if(Character.isDigit(s.charAt(i))){
                    hasDigit = true;
                }
            }
            if(flag && hasLetter && hasDigit){
                pw.println("Accept");
            }else{
                pw.println("Wrong");
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
