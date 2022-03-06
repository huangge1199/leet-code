package contest.y2022.m3.week;

import com.code.leet.entiy.TreeNode;
import com.code.leet.entiy.TwoArray;

import java.util.*;

/**
 * @description:
 * @author: Administrator
 * @date: 2021/8/22-10:29
 */
public class Solution283 {
    public static void main(String[] args) {
        Solution283 solution = new Solution283();
//        solution.minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35);
        solution.replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2});
    }

    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        for (char j = s.charAt(0); j <= s.charAt(3); j++) {
            for (int i = s.charAt(1) - '0'; i <= s.charAt(4) - '0'; i++) {
                list.add("" + j + i);
            }
        }
        return list;
    }

    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            sum += nums[i];
            k++;
        }
        return (long) k * (k + 1) / 2 - sum;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Boolean> isTree = new HashMap<>();
        for (int[] description : descriptions) {
            TreeNode pnode;
            if (map.containsKey(description[0])) {
                pnode = map.get(description[0]);
            } else {
                pnode = new TreeNode(description[0]);
                map.put(description[0], pnode);
                isTree.put(description[0], true);
            }
            TreeNode node;
            if (map.containsKey(description[1])) {
                node = map.get(description[1]);
                isTree.put(description[1], false);
            } else {
                node = new TreeNode(description[1]);
                map.put(description[1], node);
            }
            if (description[2] == 1) {
                pnode.left = node;
            } else {
                pnode.right = node;
            }
        }
        for (int key : isTree.keySet()) {
            if (isTree.get(key)) {
                return map.get(key);
            }
        }
        return null;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int bef = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = getMax(bef, nums[i]);
            if (max > 1) {
                bef = bef * (nums[i] / max);
            } else {
                while (stack.size() > 0) {
                    int num = stack.pop();
                    int temp = getMax(bef, num);
                    if (temp > 1) {
                        bef = bef * num / temp;
                    } else {
                        stack.push(num);
                        break;
                    }
                }
                stack.push(bef);
                bef = nums[i];
            }
        }
        while (stack.size() > 0) {
            int num = stack.pop();
            int temp = getMax(bef, num);
            if (temp > 1) {
                bef = bef * num / temp;
            } else {
                stack.push(num);
                break;
            }
        }
        stack.push(bef);
        while (!stack.empty()) {
            list.add(0,stack.pop());
        }
        return list;
    }

    private int getMax(int num1, int num2) {
        if (num1 > num2) {
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
        }
        int yu = 0;
        do {
            yu = num2 % num1;
            num2 = num1;
            num1 = yu;
        } while (yu != 0);
        return num2;
    }
}
