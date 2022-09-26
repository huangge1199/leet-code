//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 72 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//面试题 02.02:返回倒数第 k 个节点
public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
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
        public int kthToLast(ListNode head, int k) {
            ListNode p;
            int count = 1;
            p = head;
            while (p.next != null) {
                count++;
                p = p.next;
            }
            p = head;
            for (int i = 0; i < count - k; i++) {
                p = p.next;
            }
            return p.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}