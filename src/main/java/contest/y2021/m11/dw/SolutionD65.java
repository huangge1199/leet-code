package contest.y2021.m11.dw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionD65 {
    public static void main(String[] args) {
        SolutionD65 solution = new SolutionD65();
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            arr[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            arr[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 3 || arr[i] < -3) {
                return false;
            }
        }
        return true;
    }

    class Robot {

        int[][] arrs;
        int x;
        int y;
        int dir;

        public Robot(int width, int height) {
            arrs = new int[width][height];
            x = 0;
            y = 0;
            dir = 0;
        }

        public void move(int num) {
            num = num % (2 * arrs.length + 2 * arrs[0].length - 4);
            switch (dir) {
                case 0:
                    if (x + num >= arrs.length) {
                        dir = (dir + 1) % 4;
                        num -= arrs.length - 1 - x;
                        x = arrs.length - 1;
                        move(num);
                    } else {
                        x += num;
                    }
                    break;
                case 1:
                    if (y + num >= arrs[0].length) {
                        dir = (dir + 1) % 4;
                        num -= arrs[0].length - 1 - y;
                        y = arrs[0].length - 1;
                        move(num);
                    } else {
                        y += num;
                    }
                    break;
                case 2:
                    if (x - num < 0) {
                        dir = (dir + 1) % 4;
                        num -= x;
                        x = 0;
                        move(num);
                    } else {
                        x -= num;
                    }
                    break;
                default:
                    if (y - num < 0) {
                        dir = (dir + 1) % 4;
                        num -= y;
                        y = 0;
                        move(num);
                    } else {
                        y -= num;
                    }
                    break;
            }
        }

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            String str;
            switch (dir) {
                case 0:
                    str = "East";
                    break;
                case 1:
                    str = "North";
                    break;
                case 2:
                    str = "West";
                    break;
                default:
                    str = "South";
                    break;
            }
            return str;
        }
    }

}
