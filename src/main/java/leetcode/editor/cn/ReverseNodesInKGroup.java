//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 979 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//25:K 个一组翻转链表
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4, 5));
        solution.reverseKGroup(head, 2);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            int count = list.size() / k;
            if (count == 0 || k == 1) {
                return list.get(0);
            }
            for (int i = 0; i < count; i++) {
                for (int j = i * k; j < (i + 1) * k; j++) {
                    if (j == i * k && i == count - 1) {
                        if (list.size() % k == 0) {
                            list.get(j).next = null;
                        } else {
                            list.get(j).next = list.get((i + 1) * k);
                        }
                    } else if (j == i * k) {
                        list.get(j).next = list.get((i + 2) * k - 1);
                    } else {
                        list.get(j).next = list.get(j - 1);
                    }
                }
            }
            return list.get(k - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}