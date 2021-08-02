//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 449 👎 0

package leetcode.editor.cn;

import java.util.*;

//295:数据流的中位数
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new FindMedianFromDataStream().new Solution();
        MedianFinder medianFinder = null;
        List<String> list1 = Arrays.asList("MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian");
        List<Integer> list2 = Arrays.asList(null, -1, null, -2, null, -3, null, -4, null, -5, null);
        for (int i = 0; i < list1.size(); i++) {
            if ("MedianFinder".equals(list1.get(i))) {
                medianFinder = new FindMedianFromDataStream().new MedianFinder();
            } else if ("addNum".equals(list1.get(i))) {
                medianFinder.addNum(list2.get(i));
            } else {
                System.out.println(medianFinder.findMedian());
            }
        }
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        /**
         * 当前大顶堆和小顶堆的元素个数之和
         */
        private int count;
        private PriorityQueue<Integer> max;
        private PriorityQueue<Integer> minheap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            count = 0;
            max = new PriorityQueue<>((x, y) -> y - x);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count += 1;
            max.offer(num);
            minheap.add(max.poll());
            if ((count & 1) != 0) {
                max.add(minheap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                return (double) (max.peek() + minheap.peek()) / 2;
            } else {
                return (double) max.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}