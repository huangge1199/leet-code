//给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 
//
// 实现 SummaryRanges 类： 
//
// 
// 
// 
// SummaryRanges() 使用一个空数据流初始化对象。 
// void addNum(int val) 向数据流中加入整数 val 。 
// int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", 
//"addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//输出：
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//解释：
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // 返回 [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 10⁴ 
// 最多调用 addNum 和 getIntervals 方法 3 * 10⁴ 次 
// 
// 
// 
//
// 
//
// 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
// Related Topics 设计 二分查找 有序集合 👍 100 👎 0

package leetcode.editor.cn;

import lombok.val;

import java.util.Map;
import java.util.TreeMap;

//352:将数据流变为多个不相交区间
class DataStreamAsDisjointIntervals {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new DataStreamAsDisjointIntervals().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {

        TreeMap<Integer, Integer> treeMap;

        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> larger = treeMap.ceilingEntry(val + 1);
            Map.Entry<Integer, Integer> smaller = treeMap.floorEntry(val);
            if (smaller != null && val <= smaller.getValue()) {

            } else if (smaller != null && smaller.getValue() + 1 == val && larger != null && larger.getKey() - 1 == val) {
                int key = smaller.getKey();
                int value = larger.getValue();
                treeMap.remove(larger.getKey());
                treeMap.remove(smaller.getKey());
                treeMap.put(key, value);
            } else if (smaller != null && smaller.getValue() + 1 == val) {
                treeMap.put(smaller.getKey(), val);
            } else if (larger != null && larger.getKey() - 1 == val) {
                treeMap.put(val, larger.getValue());
                treeMap.remove(larger.getKey());
            } else {
                treeMap.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] result = new int[treeMap.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> map : treeMap.entrySet()) {
                result[index][0] = map.getKey();
                result[index][1] = map.getValue();
                index++;
            }
            return result;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}