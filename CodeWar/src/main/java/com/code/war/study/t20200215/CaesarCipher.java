package com.code.war.study.t20200215;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: hyy
 * @Date: 2020-02-15 17:33
 */

public class CaesarCipher {
    public static List<String> movingShift(String s, int shift) {
        int length = s.length() % 5 == 0 ? s.length() / 5 : s.length() / 5 + 1;
        int count = 0;
        List<String> result = Arrays.asList("", "", "", "", "");
        for (int i = 0; i < s.length(); i++) {
            int index = index = (int) s.charAt(i) + shift + i;
            char ch = ' ';
            if ((int) s.charAt(i) > 64 && (int) s.charAt(i) < 91) {
                while (index > 90) {
                    index -= 26;
                }
                ch = (char) (index);
            } else if ((int) s.charAt(i) > 96 && (int) s.charAt(i) < 123) {
                while (index > 122) {
                    index -= 26;
                }
                ch = (char) (index);
            } else {
                ch = s.charAt(i);
            }
            result.set(i / length, result.get(i / length) + ch);
        }
        return result;
    }

    public static String demovingShift(List<String> s, int shift) {
        String result = "";
        int num = 0;
        for (String str : s) {
            for (int i = 0; i < str.length(); i++) {
                int index = index = (int) str.charAt(i) - shift - num;
                char ch = ' ';
                if ((int) str.charAt(i) > 64 && (int) str.charAt(i) < 91) {
                    while (index < 65) {
                        index += 26;
                    }
                    ch = (char) (index);
                } else if ((int) str.charAt(i) > 96 && (int) str.charAt(i) < 123) {
                    while (index < 97) {
                        index += 26;
                    }
                    ch = (char) (index);
                } else {
                    ch = str.charAt(i);
                }
                result += ch;
                num++;
            }
        }
        return result;
    }
}
