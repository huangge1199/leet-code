//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 570 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//61:旋转链表
public class RotateList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode temp = head;
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
            k = k % list.size();
            if (k == 0) {
                return head;
            }
            ListNode newHead = list.get(list.size() - k);
            list.get(list.size() - 1).next = head;
            list.get(list.size() - k - 1).next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}