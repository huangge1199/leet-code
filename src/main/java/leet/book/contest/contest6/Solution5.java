package leet.book.contest.contest6;

import com.code.leet.entiy.ListNode;
import com.code.leet.entiy.TreeNode;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        ListNode head = new ListNode(Arrays.asList(14, 7, 13, 15, 7, 1, 5, 9, 8, 7));
        solution.linkedListGame(head, 4);
    }


    public ListNode linkedListGame(ListNode head, int num) {
        ListNode temp = head;
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 1) {
                temp.next = rev(temp.next, i);
                for (int j = 0; j < i; j++) {
                    temp = temp.next;
                }
            } else {
                temp.next = del(temp.next, i);
            }
        }
        return head;
    }

    private ListNode del(ListNode head, int num) {
        if (num == 0) {
            return head;
        }
        return del(head.next, num - 1);
    }

    private ListNode rev(ListNode head, int num) {
        ListNode tHead = null;
        ListNode next = null;
        ListNode temp = head;
        for (int i = 0; i < num; i++) {
            next = temp.next;
            temp.next = tHead;
            tHead = temp;
            temp = next;
        }
        head.next = next;
        return tHead;
    }
}
