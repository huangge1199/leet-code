//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。 
//
// 实现 MovingAverage 类： 
//
// 
// MovingAverage(int size) 用窗口大小 size 初始化对象。 
// double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//输出：
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//解释：
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // 返回 1.0 = 1 / 1
//movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
//movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= size <= 1000 
// -10⁵ <= val <= 10⁵ 
// 最多调用 next 方法 10⁴ 次 
// 
// Related Topics 设计 队列 数组 数据流 👍 66 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//346:数据流中的移动平均值
class MovingAverageFromDataStream {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new MovingAverageFromDataStream().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        Queue<Integer> queue;
        int size;
        double sum = 0.0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() >= size) {
                sum += 1.0 * (val - queue.poll()) / size;
            } else {
                if (queue.isEmpty()) {
                    sum += val;
                } else {
                    sum = (sum * queue.size() + val) / (queue.size() + 1);
                }
            }
            queue.offer(val);
            return sum;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}