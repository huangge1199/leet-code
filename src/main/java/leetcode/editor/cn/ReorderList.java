//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 593 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//143:重排链表
public class ReorderList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReorderList().new Solution();
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
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode temp = head.next;
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
            temp = head;
            int size = list.size();
            int count = (size + 1) / 2;
            for (int i = 1; i <= count; i++) {
                if (size - i != i - 1) {
                    temp.next = list.get(size - i);
                    temp.next.next = list.get(i - 1);
                    temp = temp.next.next;
                } else {
                    temp.next = list.get(i - 1);
                    temp = temp.next;
                }
            }
            temp.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}