package com.code.leet.study.t2021.t20210305;

import com.code.leet.entiy.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * <p>
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * <p>
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 *  
 * <p>
 * 提示：
 * <p>
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-components
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumComponents {
    /**
     * 817. 链表组件
     */
    public int numComponents(ListNode head, int[] G) {
        int num = 0;
        boolean bl = false;
        List<Integer> list = Arrays.stream(G).boxed().collect(Collectors.toList());

        while (head != null) {
            if (list.contains(head.val)) {
                bl = true;
            } else {
                if (bl) {
                    num++;
                }
                bl = false;
            }
            head = head.next;
        }
        num = bl ? num + 1 : num;
        return num;
    }
}
