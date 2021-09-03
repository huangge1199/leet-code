//设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。 
//
// 实现 TwoSum 类： 
//
// 
// TwoSum() 使用空数组初始化 TwoSum 对象 
// void add(int number) 向数据结构添加一个数 number 
// boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 
//false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//输出：
//[null, null, null, null, true, false]
//
//解释：
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4，返回 true
//twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false 
//
// 
//
// 提示： 
//
// 
// -10⁵ <= number <= 10⁵ 
// -2³¹ <= value <= 2³¹ - 1 
// 最多调用 5 * 10⁴ 次 add 和 find 
// 
// Related Topics 设计 数组 哈希表 双指针 数据流 👍 53 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//170:两数之和 III - 数据结构设计
class TwoSumIiiDataStructureDesign {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new TwoSumIiiDataStructureDesign().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            list = new ArrayList<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            list.add(number);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            Collections.sort(list);
            int start = 0;
            int end = list.size() - 1;
            while (start < end) {
                if (list.get(start) + list.get(end) == value) {
                    return true;
                }
                if (list.get(start) + list.get(end) > value) {
                    end--;
                } else {
                    start++;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}