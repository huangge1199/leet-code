//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1168 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//148:排序链表
public class SortList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            Collections.sort(list, (n1, n2) -> n1.val - n2.val);
            int size = list.size();
            if (size == 0) {
                return null;
            }
            head = list.get(0);
            ListNode temp = head;
            for (int i = 1; i < size; i++) {
                temp.next = list.get(i);
                temp.next.next = null;
                temp = temp.next;
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}