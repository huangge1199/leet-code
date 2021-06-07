//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。 
//
// 同时给定列表 G，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 输入: 
//head: 0->1->2->3
//G = [0, 1, 3]
//输出: 2
//解释: 
//链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
// 示例 2： 
//
// 输入: 
//head: 0->1->2->3->4
//G = [0, 3, 1, 4]
//输出: 2
//解释: 
//链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 如果 N 是给定链表 head 的长度，1 <= N <= 10000。 
// 链表中每个结点的值所在范围为 [0, N - 1]。 
// 1 <= G.length <= 10000 
// G 是链表中所有结点的值的一个子集. 
// 
// Related Topics 链表 
// 👍 74 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//817:链表组件
public class LinkedListComponents{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LinkedListComponents().new Solution();
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
    public int numComponents(ListNode head, int[] nums) {
        int num = 0;
        boolean bl = false;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (head != null) {
            if (list.contains(head.val)) {
                bl = true;
            } else {
                if (bl) {
                    num++;
                }
                bl = false;
            }
            head = head.next;
        }
        num = bl ? num + 1 : num;
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}