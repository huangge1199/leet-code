package contest.y2021.m10.week;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution264 {
    public static void main(String[] args) {
        Solution264 solution = new Solution264();
    }

    public int countValidWords(String sentence) {
        String regex = "[a-z]*([a-z]+[-][a-z]+)?[!.,]?";
        if (!sentence.contains(" ")) {
            if (Pattern.compile(regex).matcher(sentence).matches()) {
                return 1;
            } else {
                return 0;
            }
        }
        String[] strs = sentence.split(" ");
        int count = 0;
        for (String str : strs) {
            if (!str.equals("") && Pattern.compile(regex).matcher(str).matches()) {
                count++;
            }
        }
        return count;
    }

    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            int[] arrs = new int[10];
            int temp = i;
            while (temp > 9 && temp % 10 > 0) {
                arrs[temp % 10]++;
                temp /= 10;
            }
            if (temp > 9) {
                continue;
            }
            arrs[temp]++;
            boolean bl = true;
            for (int j = 1; j < 10; j++) {
                if (arrs[j] > 0 && arrs[j] != j) {
                    bl = false;
                    break;
                }
            }
            if (bl) {
                return i;
            }
        }
    }
}
