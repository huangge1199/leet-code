package contest.y2021.m04.week;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 轩辕龙儿
 * Date: 2021/4/25
 * Time: 10:29
 * Description: No Description
 */
public class Solution238 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
//        System.out.println(solution238.sumBase(42, 2));

        System.out.println(solution238.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(solution238.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(solution238.longestBeautifulSubstring("a"));
    }

    public int sumBase(int n, int k) {
        int sum = 0;
        String str = "";
        while (n > 0) {
            str += n % k;
            n /= k;
        }
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

    public int longestBeautifulSubstring(String word) {
        if (word.length() < 5) {
            return 0;
        }
        int num = 1;
        int max = 0;
        int index = word.indexOf("a");
        int ch = 'a';
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int flag = 0;
        while (index >= 0) {
            for (int i = index + 1; i < word.length(); i++) {
                if (word.charAt(i) != ch && word.charAt(i) != ch + 1) {
                    if (ch == 'e') {
                        max = Math.max(num, max);
                    }
                    index = index + num + word.substring(index + num).indexOf("a");
                    num = 1;
                    flag = 0;
                    break;
                }
                if (word.charAt(i) == ch) {
                    num++;
                }
                if (word.charAt(i) == list.get(flag + 1)) {
                    ch = ch + 1;
                    flag++;
                }
            }
        }
        return max;
    }
}
