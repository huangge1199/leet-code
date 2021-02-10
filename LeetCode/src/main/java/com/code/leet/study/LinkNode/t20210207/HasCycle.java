package com.code.leet.study.LinkNode.t20210207;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasCycle {
    /**
     * 141. 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return true;
            } else {
                list.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
