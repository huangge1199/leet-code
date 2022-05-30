package contest.y2022.m5.week;

import org.omg.CORBA.INTERNAL;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/29 上午10:31
 */
public class Solution295 {
    public int rearrangeCharacters(String s, String target) {
        Map<Integer, Integer> tmap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            int key = ch - 'a';
            tmap.put(key, tmap.getOrDefault(key, 0) + 1);
        }
        Map<Integer, Integer> smap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int key = ch - 'a';
            if (tmap.containsKey(key)) {
                smap.put(key, smap.getOrDefault(key, 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key : tmap.keySet()) {
            if (!smap.containsKey(key)) {
                return 0;
            }
            int count = smap.get(key) / tmap.get(key);
            if (count == 0) {
                return 0;
            }
            min = Math.min(min, count);
        }
        return min;
    }

    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher isNum = pattern.matcher(str.substring(1));
            if (str.startsWith("$") && isNum.matches()) {
                double num = Double.parseDouble(str.substring(1)) * (100 - discount) / 100;
                sb.append("$").append(String.format("%.2f", num)).append(" ");
            } else {
                sb.append(str).append(" ");
            }
        }
        String result = sb.toString();
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public int totalSteps(int[] nums) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        boolean is1 = true;
        boolean isr = false;
        q1.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                q1.add(nums[i]);
            } else {
                isr = true;
            }
        }
        if (!isr) {
            return 0;
        }
        int count = 0;
        while (isr) {
            count++;
            isr = false;
            if (q1.isEmpty()) {
                q1.add(q2.poll());
                while (!q2.isEmpty()) {
                    if (q1.peek() <= q2.peek()) {
                        q1.add(q2.poll());
                    } else {
                        q2.poll();
                        isr = true;
                    }
                }
            } else {
                q2.add(q1.poll());
                while (!q1.isEmpty()) {
                    if (q2.peek() <= q1.peek()) {
                        q2.add(q1.poll());
                    } else {
                        q1.poll();
                        isr = true;
                    }
                }
            }
        }
        return count;
    }
//    public int totalSteps(int[] nums) {
//        int max = 0;
//        int[] counts = new int[nums.length];
//        int[] adds = new int[nums.length];
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int count = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    count++;
//                    j += Math.min(count, adds[j]);
//                    adds[i] += Math.min(count, counts[j]);
//                } else {
//                    break;
//                }
//            }
//            counts[i] = count;
//            max = Math.max(max, count);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        Solution295 solution = new Solution295();
        solution.rearrangeCharacters("ilovecodingonleetcode", "code");
    }
}
