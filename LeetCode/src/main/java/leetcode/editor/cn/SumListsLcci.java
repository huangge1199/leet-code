//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 57 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//面试题 02.05:链表求和
public class SumListsLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SumListsLcci().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0;
            ListNode head = l1;
            ListNode temp = null;
            while (l1 != null && l2 != null) {
                sum += l1.val + l2.val;
                l1.val = sum % 10;
                sum = sum / 10;
                if (l1.next == null) {
                    temp = l1;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                sum += l1.val;
                l1.val = sum % 10;
                sum = sum / 10;
                if (l1.next == null) {
                    temp = l1;
                }
                l1 = l1.next;
            }
            while (l2 != null && temp != null) {
                sum += l2.val;
                temp.next = new ListNode(sum % 10);
                sum = sum / 10;
                temp = temp.next;
                l2 = l2.next;
            }
            if (sum > 0) {
                temp.next = new ListNode(sum);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}