//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 232 👎 0

package leetcode.editor.cn;

import com.code.leet.entiy.ListNode;

//707:设计链表
public class DesignLinkedList {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new DesignLinkedList().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        private ListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = null;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index == 0) {
                return head.val;
            }
            ListNode temp = head;
            int i = 0;
            while (temp != null && i < index) {
                temp = temp.next;
                i++;
            }
            if (i == index && temp != null) {
                return temp.val;
            } else {
                return -1;
            }
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode temp = head;
            if (temp == null) {
                head = new ListNode(val);
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            ListNode temp = head;
            ListNode front = head;
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (temp == null) {
                return;
            }
            int i = 1;
            temp = temp.next;
            while (temp != null && i < index) {
                temp = temp.next;
                front = front.next;
                i++;
            }
            if (i == index && temp != null) {
                front.next = new ListNode(val);
                front.next.next = temp;
            } else if (i == index) {
                front.next = new ListNode(val);
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            ListNode temp = head;
            ListNode front = head;
            if (temp == null) {
                return;
            }
            if (index == 0) {
                head = head.next;
                return;
            }
            int i = 1;
            temp = temp.next;
            while (temp != null && i < index) {
                temp = temp.next;
                front = front.next;
                i++;
            }
            if (i == index && temp != null) {
                front.next = temp.next;
            }
        }

        public void print() {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val + ",");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//runtime:13 ms
//memory:39.3 MB

//leetcode submit region end(Prohibit modification and deletion)

}