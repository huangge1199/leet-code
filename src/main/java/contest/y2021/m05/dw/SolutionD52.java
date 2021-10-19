package contest.y2021.m05.dw;

import java.util.*;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/5/15 22:25
 * @Description:
 */
public class SolutionD52 {
    public static void main(String[] args) {
        SolutionD52 solution = new SolutionD52();
        solution.rotateTheBox(new char[][]{{'*', '#', '*', '.', '.', '.', '#', '.', '*', '.'}});
    }

    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (String str : strs) {
            int num = Integer.parseInt(str.substring(str.length() - 1));
            str = str.substring(0, str.length() - 1) + " ";
            map.put(num, str);
        }
        s = "";
        for (int i = 1; i < 10; i++) {
            if (map.containsKey(i)) {
                s += map.get(i);
            } else {
                break;
            }
        }
        return s.substring(0, s.length() - 1);
    }

    public int[] memLeak(int memory1, int memory2) {
        boolean isOne = memory1 >= memory2;
        int i = 1;
        while (true) {
            if (isOne) {
                if (memory1 < i) {
                    break;
                }
                memory1 -= i;
            } else {
                if (memory2 < i) {
                    break;
                }
                memory2 -= i;
            }
            i++;
            isOne = memory1 >= memory2;
        }
        return new int[]{i, memory1, memory2};
    }

    public char[][] rotateTheBox(char[][] box) {
        char[][] newBox = new char[box[0].length][box.length];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < box.length; i++) {
            int del = 0;
            boolean isStone = false;
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == '.' && !stack.isEmpty() && stack.peek() == '#') {
                    if (isStone) {
                        del++;
                    }
                    continue;
                }
                if (box[i][j] == '*' || j == box[i].length - 1) {
                    if (del > 0) {
                        Stack<Character> temp = new Stack<>();
                        while (!stack.isEmpty() && stack.peek() != '*') {
                            temp.push(stack.pop());
                        }
                        for (int l = 0; l < del; l++) {
                            stack.push('.');
                        }
                        del = 0;
                        while (!temp.isEmpty()) {
                            stack.push(temp.pop());
                        }
                    }
                    isStone = true;
                }
                stack.push(box[i][j]);
            }
            int count = box[0].length - 1;
            while (!stack.isEmpty()) {
                newBox[count][box.length - 1 - i] = stack.pop();
                count--;
            }
            for (int j = count; j >= 0; j--) {
                newBox[j][box.length - 1 - i] = '.';
            }
        }
        return newBox;
    }

    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                sum += temp;
                continue;
            } else {
                temp = 0;
            }
            for (int j = i; j < nums.length; j++) {
                int num = nums[j] / nums[i];
                sum += num;
                temp += num;
            }
        }
        return (int) (sum % 1000000007);
    }
}
