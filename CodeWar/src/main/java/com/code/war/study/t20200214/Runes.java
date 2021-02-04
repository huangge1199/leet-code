package com.code.war.study.t20200214;

/**
 * @Author: hyy
 * @Date: 2020-02-14 09:32
 */

public class Runes {

    public static int solveExpression(final String expression) {
        int missingDigit = -1;
        String[] nums = new String[]{"", "", ""};
        String op = "";
        int j = 0;
        nums = new String[]{expression.substring(0, 1), "", ""};
        for (int i = 1; i < expression.length(); i++) {
            if ("1234567890?".contains(expression.substring(i, i + 1))) {
                nums[j] += expression.substring(i, i + 1);
            } else if ("+*".contains(expression.substring(i, i + 1))) {
                op = expression.substring(i, i + 1);
                j++;
            } else if ("-".equals(expression.substring(i, i + 1))) {
                if ("+-*=".contains(expression.substring(i - 1, i))) {
                    nums[j] += expression.substring(i, i + 1);
                } else {
                    op = "-";
                    j++;
                }
            } else {
                j++;
            }
        }
        for (int num = 0; num < 10; num++) {
            String temp = expression;
            temp = temp.replaceAll("\\?", String.valueOf(num));
            if(num==0&&(nums[0].indexOf("?")==0||nums[1].indexOf("?")==0||nums[2].indexOf("?")==0)){
                continue;
            }
            int num1 = Integer.parseInt(nums[0].replaceAll("\\?", String.valueOf(num)));
            int num2 = Integer.parseInt(nums[1].replaceAll("\\?", String.valueOf(num)));
            int num3 = Integer.parseInt(nums[2].replaceAll("\\?", String.valueOf(num)));
            int result = 0;
            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                default:
                    break;
            }
            if (result == num3) {
                missingDigit = num;
                break;
            }
        }
        //Write code to determine the missing digit or unknown rune
        //Expression will always be in the form
        //(number)[opperator](number)=(number)
        //Unknown digit will not be the same as any other digits used in expression

        return missingDigit;
    }
}
