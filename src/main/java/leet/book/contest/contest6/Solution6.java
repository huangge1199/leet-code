package leet.book.contest.contest6;

import com.code.leet.entiy.TwoArray;

import java.util.*;

public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
    }

    public boolean checkBracketSequence(String origin) {
        int count = 0;
        for (int i = 1; i < origin.length(); i++) {
            char fch = origin.charAt(i - 1);
            char sch = origin.charAt(i);
            if (fch == '(') {
                if (Character.isDigit(sch)) {
                    String str = "";
                    while (Character.isDigit(sch)){
                        str+=sch;
                        i++;
                        if(i==origin.length()){
                            break;
                        }
                        sch = origin.charAt(i);
                    }
                    count += Integer.parseInt(str);
                    i--;
                } else {
                    count++;
                }
            } else if (fch == ')') {
                if (Character.isDigit(sch)) {
                    String str = "";
                    while (Character.isDigit(sch)){
                        str+=sch;
                        i++;
                        if(i==origin.length()){
                            break;
                        }
                        sch = origin.charAt(i);
                    }
                    count -= Integer.parseInt(str);
                    i--;
                } else {
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
        }
        char ch = origin.charAt(origin.length() - 1);
        if (ch == '(') {
            count++;
        } else if (ch == ')') {
            count--;
        }
        return count == 0;
    }
}
