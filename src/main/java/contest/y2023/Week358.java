package contest.y2023;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week358 {
    public static void main(String[] args) {
        Week358 so = new Week358();
//        ListNode head = new ListNode(Arrays.asList(9,9,9));
//        so.doubleIt(head);
    }

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + x; j < nums.size(); j++) {
                min = Math.min(min, Math.abs(nums.get(i) - nums.get(j)));
            }
        }
        return min;
    }

    public ListNode doubleIt(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        boolean bl = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            num *= 2;
            if (bl) {
                num += 1;
            }
            if (num >= 10) {
                list.set(i, num -= 10);
                bl = true;
            } else {
                list.set(i, num);
                bl = false;
            }
        }
        if (bl) {
            list.add(0, 1);
        }
        head = new ListNode(list.get(0));
        curr = head;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return head;
    }

    public int maxSum(int[] nums) {
        int maxSum = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 获取两个数数位上的最大数字
                int maxDigitI = getMaxDigit(nums[i]);
                int maxDigitJ = getMaxDigit(nums[j]);

                // 如果最大数字相等，则更新最大和
                if (maxDigitI == maxDigitJ) {
                    maxSum = Math.max(maxSum, nums[i] + nums[j]);
                }
            }
        }
        return maxSum;
    }

    public int getMaxDigit(int num) {
        int maxDigit = 0;

        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            num /= 10;
        }

        return maxDigit;
    }
}
