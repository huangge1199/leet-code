//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 1004 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//234:回文链表
public class PalindromeLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            boolean bl = true;
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int headIndex = 0;
            int size = list.size();
            while (headIndex < size - headIndex - 1) {
                if (!list.get(headIndex).equals(list.get(size - headIndex - 1))) {
                    bl = false;
                    break;
                }
                headIndex++;
            }
            return bl;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}