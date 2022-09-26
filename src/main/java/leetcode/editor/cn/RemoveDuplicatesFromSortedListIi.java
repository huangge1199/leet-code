//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 628 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//82:删除排序链表中的重复元素 II
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode front = new ListNode(-1);
            ListNode temp = front;
            int same = head.val;
            boolean flag = false;
            while (head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                    same = head.val;
                    flag = true;
                } else if (flag && head.val == same) {
                    head = head.next;
                } else {
                    temp.next = head;
                    temp = temp.next;
                    head = head.next;
                }
            }
            if (head.val == same) {
                temp.next = null;
            } else {
                temp.next = head;
            }
            return front.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}