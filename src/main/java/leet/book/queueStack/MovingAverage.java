package leet.book.queueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 轩辕龙儿
 * @date: 2021/7/2 8:44
 * @Description: No Description
 */
public class MovingAverage {
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