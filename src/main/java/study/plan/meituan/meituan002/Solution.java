package study.plan.meituan.meituan002;

import java.io.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author huangge1199
 * @Date 2021/8/23 15:39
 **/

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n + 1];
        int[] prev = new int[n + 1];
        String[] w = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(w[i - 1]);
            prev[i] += prev[i - 1] + arr[i];
        }

        int[][] d = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            d[i] = new int[]{-1, -1};
        }

        int[] res = new int[n];

        int maxW = 0;
        String[] q = reader.readLine().split(" ");
        for (int i = n - 1; i >= 0; i--) {
            int x = Integer.parseInt(q[i]);
            res[i] = maxW;
            if (i == 0) break;
            //更新最大重量
            int cur = arr[x];
            int left = x, right = x;
            //每次只会将左右两块区域连成一块,我们只需关心一段区间的左边界和右边界,就能通过前缀和数组查询到区间和
            if (x + 1 <= n && d[x + 1][0] != -1) {
                cur += prev[d[x + 1][1]] - prev[d[x + 1][0] - 1];
                right = d[x + 1][1]; //更新右边界
            }
            if (x - 1 > 0 && d[x - 1][1] != -1) {
                cur += prev[d[x - 1][1]] - prev[d[x - 1][0] - 1];
                left = d[x - 1][0]; //更新左边界
            }

            maxW = Math.max(maxW, cur);
            //更新两端点的左右区间
            d[left][0] = left;
            d[left][1] = right;
            d[right][0] = left;
            d[right][1] = right;
        }

        for (int i = 0; i < n; i++) {
            writer.write(res[i] + "\n");
        }

        writer.close();
        reader.close();
    }
}

