//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 916 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//92:反转链表 II
public class ReverseLinkedListIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseLinkedListIi().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == 1) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        int num = 1;
        ListNode before = new ListNode(0);
        ListNode after = null;
        ListNode temp = head;
        while (temp != null) {
            if (num == m - 1) {
                before = temp;
            }
            if (num >= m && num <= n) {
                list.add(temp);
            }
            if (num == n) {
                after = temp.next;
                break;
            }
            temp = temp.next;
            num++;
        }
        ListNode newHead = before;
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            before.next = list.get(i);
            before = before.next;
        }
        before.next = after;
        if (m == 1) {
            head = newHead.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}