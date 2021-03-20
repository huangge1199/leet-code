//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 168 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.Node;

import java.util.Arrays;
import java.util.List;

//剑指 Offer 35:复杂链表的复制
public class FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        List<Integer> var = Arrays.asList(7, 13, 11, 10, 1);
        List<Integer> random = Arrays.asList(null, 0, 4, 2, 0);
        Node head = new Node(0);
        head = head.setHead(var, random);
        solution.copyRandomList(head);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node clone = head;
            while (clone != null) {
                Node temp = new Node(clone.val);
                temp.next = clone.next;
                clone.next = temp;
                clone = temp.next;
            }
            clone = head;
            while (clone != null) {
                if (clone.random != null) {
                    clone.next.random = clone.random.next;
                }
                clone = clone.next.next;
            }
            clone = head.next;
            Node temp = head;
            Node newHead = clone;
            while (temp != null && newHead != null) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                    newHead.next = newHead.next.next;
                } else {
                    temp.next = null;
                }
                temp = temp.next;
                newHead = newHead.next;
            }

            return clone;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}