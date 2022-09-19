//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 243 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//剑指 Offer 24:反转链表
public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode p = head;
            ListNode pPrev = null;
            while (p != null) {
                ListNode temp = p.next;
                if (temp == null) {
                    newHead = p;
                }
                p.next = pPrev;
                pPrev = p;
                p = temp;
            }
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}