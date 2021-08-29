package study.plan.meituan.meituan012;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    //
//    static Scanner sc;
//    static PrintWriter pw;
//
//    public static void main(String[] args) throws IOException {
//        sc = new Scanner(System.in);
//        pw = new PrintWriter(System.out);
//        solve();
//        pw.close();
//    }
//
//    public static void solve() throws IOException {
//        int M = sc.nextInt();
//        int N = sc.nextInt();
//        int Q = sc.nextInt();
//        boolean[] use = new boolean[M + 1];
//        int[] pos = new int[M + 1];
//        boolean[] isLock = new boolean[N + 1];
//        Arrays.fill(pos, -1);
//        for (int i = 0; i < Q; i++) {
//            int op = sc.nextInt();
//            int x, y;
//            switch (op) {
//                case 1:
//                    x = sc.nextInt();
//                    y = sc.nextInt();
//                    if (!use[x] && !isLock[y] && (pos[x] == -1 || !isLock[pos[x]])) {
//                        pos[x] = y;
//                    }
//                    break;
//                case 2:
//                    y = sc.nextInt();
//                    isLock[y] = true;
//                    break;
//                case 3:
//                    y = sc.nextInt();
//                    isLock[y] = false;
//                    break;
//                case 4:
//                    x = sc.nextInt();
//                    if (!use[x] && pos[x] > -1 && !isLock[pos[x]]) {
//                        use[x] = true;
//                        pw.println(pos[x]);
//                    } else {
//                        pw.println(-1);
//                    }
//                    break;
//                default:
//                    x = sc.nextInt();
//                    use[x] = false;
//                    break;
//            }
//        }
//    }
//
//    static class Scanner {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public Scanner(InputStream s) {
//            br = new BufferedReader(new InputStreamReader(s));
//        }
//
//        public Scanner(FileReader f) {
//            br = new BufferedReader(f);
//        }
//
//        public String next() throws IOException {
//            while (st == null || !st.hasMoreTokens())
//                st = new StringTokenizer(br.readLine());
//            return st.nextToken();
//        }
//
//        public int nextInt() throws IOException {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() throws IOException {
//            return Long.parseLong(next());
//        }
//
//        public double nextDouble() throws IOException {
//            return Double.parseDouble(next());
//        }
//
//        public int[] nextIntArr(int n) throws IOException {
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = Integer.parseInt(next());
//            }
//            return arr;
//        }
//
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(), M = scan.nextInt(), Q = scan.nextInt();
        int[] bookshelf = new int[N + 1];//编号为i的书在书架第bookshelf[i]行
        boolean[] isLock = new boolean[M + 1];//记录哪些行有上锁
        int[] hasBooks = new int[N + 1];//记录小团借了哪些书
        Arrays.fill(bookshelf, -1);

        for (int i = 0; i < Q; i++) {
            //1:放书  2:对行上锁  3:对行去锁  4:借书  5:还书
            int oper = scan.nextInt(), x, y;
            switch (oper) {
                case 1:
                    x = scan.nextInt();
                    y = scan.nextInt();
                    //没有放置到一个锁了的行上 并且 该书本不在小团手上  并且 (原来该书不在书架上 或 原来该书在书架上且原行没上锁)
                    if (!isLock[y] && hasBooks[x] != 1 && (bookshelf[x] == -1 || !isLock[bookshelf[x]]))
                        bookshelf[x] = y;//把编号为x的书放到y行书架
                    break;
                case 2:
                    y = scan.nextInt();
                    isLock[y] = true;//对y行上锁
                    break;
                case 3:
                    y = scan.nextInt();
                    isLock[y] = false;//对y行去锁
                    break;
                case 4:
                    x = scan.nextInt();
                    y = bookshelf[x];
                    //如果可以借到书(书本在书架上,且该行没上锁,且不在小团手上)
                    if (y != -1 && !isLock[y] && hasBooks[x] != 1) {
                        System.out.println(y);
                        hasBooks[x] = 1;//更新小团借的书
                        bookshelf[x] = -1;//将书架上对应位置置空
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case 5:
                    x = scan.nextInt();
                    //还书
                    if (hasBooks[x] != 0) {
                        hasBooks[x] = 0;
                    }
                    break;
            }
        }

        scan.close();
    }
}
