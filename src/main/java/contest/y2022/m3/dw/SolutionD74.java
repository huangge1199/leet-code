package contest.y2022.m3.dw;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2022/2/19 22:28
 */
public class SolutionD74 {
    public static void main(String[] args) {
        SolutionD74 solutionD72 = new SolutionD74();
        System.out.println(solutionD72.minimumWhiteTiles("1110111", 2, 1));
    }

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        long sum = 0;
        char ch1 = pattern.charAt(0);
        char ch2 = pattern.charAt(1);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch1) {
                num1++;
            } else if (text.charAt(i) == ch2) {
                sum += num1;
                num2++;
            }
        }
        return sum + Math.max(num1, num2);
    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int j : nums) {
            queue.add((double) j);
            sum += j;
        }
        double cur = sum;
        int count = 0;
        while (cur > sum / 2) {
            double num = queue.poll();
            cur -= num / 2;
            queue.add(num / 2);
            count++;
        }
        return count;
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        if (numCarpets * carpetLen >= floor.length()) {
            return 0;
        }
        if ("".equals(floor)) {
            return 0;
        }
        if (numCarpets == 0) {
            int count = 0;
            int i = floor.indexOf("1");
            while (i >= 0) {
                count++;
                if (i + 1 < floor.length()) {
                    floor = floor.substring(i + 1);
                } else {
                    break;
                }
            }
            return count;
        }
        while (floor.startsWith("0")) {
            floor = floor.substring(1);
        }
        if (floor.equals("")) {
            return 0;
        }
        if (floor.length() <= carpetLen * numCarpets) {
            return 0;
        }
        int c1 = 1 + minimumWhiteTiles(floor.substring(1), numCarpets, carpetLen);
        int c2 = minimumWhiteTiles(floor.substring(carpetLen), numCarpets - 1, carpetLen);
        return Math.min(c1, c2);
    }
}
