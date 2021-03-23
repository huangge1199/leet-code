//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 13 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1721:交换链表中的节点
public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        Solution solution = new SwappingNodesInALinkedList().new Solution();
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list = Arrays.asList(7, 9, 6, 6, 7, 8, 3, 0, 9, 5);
        solution.swapNodes(new ListNode(list), 5);
    }

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
        public ListNode swapNodes(ListNode head, int k) {
            List<ListNode> list = new ArrayList<>();
            ListNode temp = head;
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
            int tem = list.get(k - 1).val;
            list.get(k - 1).val = list.get(list.size() - k).val;
            list.get(list.size() - k).val = tem;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}