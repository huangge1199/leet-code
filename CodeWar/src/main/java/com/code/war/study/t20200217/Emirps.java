package com.code.war.study.t20200217;

/**
 * @Author: hyy
 * @Date: 2020-02-17 20:40
 */

public class Emirps {

    public static long[] findEmirp(long n) {
        // your code
        long[] emirps = new long[(int) n];
        long[] temp = new long[(int) n];
        int eIndex = 0;
        int rIndex = 0;
        int sum = 0;
        for (long i = 2; i < n; i++) {
            boolean isEmirps = true;
            for (int j = 0; j < eIndex; j++) {
                if (i % emirps[j] == 0) {
                    isEmirps = false;
                    break;
                }
            }
            if (isEmirps) {
                emirps[eIndex] = i;
                eIndex++;
                String str = String.valueOf(i);
                int count = 0;
                int start = 0;
                int end = str.length() - 1;
                while (start < end) {
                    if (str.charAt(start) == str.charAt(end)) {
                        count++;
                    }
                    start++;
                    end++;
                }
                if (count < str.length() / 2) {
                    temp[rIndex] = i;
                    rIndex++;
                    sum += i;
                }
            }
        }
        return new long[]{rIndex, rIndex > 0 ? temp[rIndex - 1] : 0, sum};
    }
}
