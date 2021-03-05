package com.code.leet.study.t2021.t20210305;

import com.code.leet.entiy.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 */
public class RemoveZeroSumSublists {
    /**
     * 1171. 从链表中删去总和值为零的连续节点
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode temp = head;
        while (temp != null) {
            sum += temp.val;
            if (sum == 0 || map.containsKey(sum)) {
                if (sum == 0) {
                    head = temp.next;
                } else {
                    map.get(sum).next = temp.next;
                }
                if (head != null) {
                    map = new HashMap<>();
                    temp = head;
                    sum = head.val;
                } else {
                    return head;
                }
            }
            while (temp.next != null && temp.next.val == 0) {
                temp.next = temp.next.next;
            }
            map.put(sum, temp);
            temp = temp.next;
        }
        return head;
    }
}
