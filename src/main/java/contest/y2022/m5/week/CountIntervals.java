package contest.y2022.m5.week;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * leet-code
 *
 * @author 轩辕龙儿
 * @date 2022/5/15 11:41
 */
public class CountIntervals {
    TreeSet<Interval> ranges;
    int cnt;

    public CountIntervals() {
        ranges = new TreeSet();
        cnt = 0;
    }

    public void add(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            cnt -= iv.right - iv.left + 1;
            itr.remove();
        }
        ranges.add(new Interval(left, right));
        cnt += right - left + 1;
    }

    public int count() {
        return cnt;
    }
}

class Interval implements Comparable<Interval> {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int compareTo(Interval that) {
        if (this.right == that.right) return this.left - that.left;
        return this.right - that.right;
    }
}
