### 解题思路
执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39 MB, 在所有 Java 提交中击败了9.73%的用户

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode helper = res;
        int temp = 0;
        int up = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + up;
            if ( sum > 9) {
                temp = sum - 10;
                up = 1;
            } else {
                temp = sum;
                up = 0;
            }
            helper.next = new ListNode(temp);
            helper = helper.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode helper2 = l1 == null ? l2 : l1;
        while (helper2 != null) {
            int sum = helper2.val + up;
            if ( sum > 9) {
                temp = sum - 10;
                up = 1;
            } else {
                temp = sum;
                up = 0;
            }
            helper.next = new ListNode(temp);
            helper = helper.next;
            helper2 = helper2.next;
        }

        if (up == 1) {
            helper.next = new ListNode(up);
            helper = helper.next;
        }
        return res.next;
    }
}
```