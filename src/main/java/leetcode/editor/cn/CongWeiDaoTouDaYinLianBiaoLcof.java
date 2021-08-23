//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 173 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 06:从尾到头打印链表
class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] arr = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = list.get(size - 1 - i);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}