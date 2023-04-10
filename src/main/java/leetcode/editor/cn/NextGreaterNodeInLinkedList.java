//给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。 
//
// 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.
//val，那么就有 j > i 且 node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0
// 。 
//
// 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。 
//
// 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 输入：[2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 示例 3： 
//
// 输入：[1,7,5,1,9,2,5,1]
//输出：[7,9,9,9,0,5,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 对于链表中的每个节点，1 <= node.val <= 10^9 
// 给定列表的长度在 [0, 10000] 范围内 
// 
// Related Topics 栈 链表 
// 👍 156 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1019:链表中的下一个更大节点
public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NextGreaterNodeInLinkedList().new Solution();
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
        //        public int[] nextLargerNodes(ListNode head) {
//            List<Integer> list = new ArrayList<>();
//            List<Integer> result = new ArrayList<>();
//            List<Integer> indexs = new ArrayList<>();
//            int max = 0;
//            int index = 0;
//            while (head != null) {
//                indexs.add(index);
//                if (head.val > max) {
//                    int size = indexs.size();
//                    for (int i = 0; i < size; i++) {
//                        if (head.val > result.get(indexs.get(i))) {
//                            result.set(indexs.get(i), head.val);
//                            indexs.remove(indexs.get(i));
//                        }
//                    }
//                    max = head.val;
//                }
//                index++;
//                result.add(0);
//                list.add(head.val);
//                head = head.next;
//            }
//            result.add(0);
//            return result.stream().mapToInt(Integer::valueOf).toArray();
//        }
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> indexs = new LinkedList<>();
            int index = 0;
            while (head != null) {
                while (!queue.isEmpty() && head.val > queue.peek()) {
                    result.set(indexs.poll(), head.val);
                    queue.poll();
                }
                queue.add(head.val);
                indexs.add(index);
                result.add(0);
                index++;
                head = head.next;
            }
            result.add(0);
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}