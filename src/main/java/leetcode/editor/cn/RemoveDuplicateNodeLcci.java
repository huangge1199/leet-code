//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 108 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//面试题 02.01:移除重复节点
public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
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
        public ListNode removeDuplicateNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode temp = head;
            ListNode pro = null;
            while (temp != null) {
                if (list.contains(temp.val)) {
                    pro.next = temp.next;
                } else {
                    list.add(temp.val);
                    pro = temp;
                }
                temp = temp.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}