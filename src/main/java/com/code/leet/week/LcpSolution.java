package com.code.leet.week;

import java.util.*;

/**
 * @Author: 轩辕龙儿
 * @Date: 2021/4/5 15:02
 * @Description:
 */
public class LcpSolution {
    public static void main(String[] args) {
        LcpSolution solution = new LcpSolution();
//        System.out.println(solution.orchestraLayout(4, 1, 2));

        int[] nums = {2, 2, 3, 5};
        int target = 6;
        System.out.println(solution.purchasePlans(nums, target));
    }

    public int magicTower(int[] nums) {
        long sum = 1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            if (nums[i] < 0) {
                while (!stack1.isEmpty() && stack1.peek() < nums[i]) {
                    stack2.push(stack1.pop());
                }
                stack1.push(nums[i]);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            if (sum <= 0) {
                sum -= stack1.peek();
                list.add(stack1.pop());
                count++;
            }
        }
        size = list.size();
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
            if (sum <= 0) {
                return -1;
            }
        }
        return count;
    }

    public int orchestraLayout(int num, int xPos, int yPos) {
        int round = Math.min(Math.min(xPos, num - xPos - 1), Math.min(yPos, num - yPos - 1));
        int result = 4 * num * round - 4 * round * round;
        if (xPos == round) {
            result += yPos - round + 1;
        } else if (yPos == num - 1 - round) {
            result += (num - 1 - round * 2) + xPos - round + 1;
        } else if (xPos == num - 1 - round) {
            result += (num - 1 - round * 2) * 2 + num - round - yPos;
        } else {
            result += (num - 1 - round * 2) * 3 + num - round - xPos;
        }
        return result % 9;
    }

    //    public int purchasePlans(int[] nums, int target) {
//        long count = 0;
//        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        Collections.sort(numList);
//        Map<Integer, Long> map = new HashMap<>();
//        int temp = -1;
//        for (int num : numList) {
//            if (num >= target) {
//                break;
//            }
//            if (temp == -1) {
//                for (int i = 1; i < num; i++) {
//                    map.put(i, Long.parseLong("0"));
//                }
//                map.put(num, Long.parseLong("1"));
//            } else {
//                if (map.containsKey(target - num)) {
//                    count += map.get(target - num);
//                } else {
//                    count += map.get(temp);
//                }
//                for (int i = temp + 1; i < num; i++) {
//                    map.put(i, map.get(temp));
//                }
//                map.put(num, map.get(temp) + 1);
//            }
//            temp = num;
//        }
//        return (int) (count % (Math.pow(10, 9) + 7));
//    }
    public int purchasePlans(int[] nums, int target) {
        int[] sort = new int[target];
        long[] count = new long[target];
        for (int num : nums) {
            if (num < target) {
                sort[num] += 1;
            }
        }
        long sum = 0;
        for (int i = 1; i < target; i++) {
            sum += sort[i];
            count[i] = sum;
        }
        long result = 0;
        for (int num : nums) {
            if (target > num) {
                result += num <= target - num ? count[target - num] - 1 : count[target - num];
            }
        }
        Calendar calendar = Calendar.getInstance();
        return (int) (result / 2 % (Math.pow(10, 9) + 7));
    }
}
