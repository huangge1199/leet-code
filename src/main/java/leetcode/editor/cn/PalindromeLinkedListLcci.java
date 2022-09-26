//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 66 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//面试题 02.06:回文链表
public class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        ListNode temp;

        public boolean isPalindrome(ListNode head) {
            temp = head;
            return isP(head);
        }

        public boolean isP(ListNode curNode) {
            if (curNode != null) {
                if (isP(curNode.next)) {
                    if (curNode.val != temp.val) {
                        return false;
                    }
                    temp = temp.next;
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}