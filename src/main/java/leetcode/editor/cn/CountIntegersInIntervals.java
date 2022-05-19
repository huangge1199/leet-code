//<p>给你区间的 <strong>空</strong> 集，请你设计并实现满足要求的数据结构：</p>
//
//<ul>
//	<li><strong>新增：</strong>添加一个区间到这个区间集合中。</li>
//	<li><strong>统计：</strong>计算出现在 <strong>至少一个</strong> 区间中的整数个数。</li>
//</ul>
//
//<p>实现 <code>CountIntervals</code> 类：</p>
//
//<ul>
//	<li><code>CountIntervals()</code> 使用区间的空集初始化对象</li>
//	<li><code>void add(int left, int right)</code> 添加区间 <code>[left, right]</code> 到区间集合之中。</li>
//	<li><code>int count()</code> 返回出现在 <strong>至少一个</strong> 区间中的整数个数。</li>
//</ul>
//
//<p><strong>注意：</strong>区间 <code>[left, right]</code> 表示满足 <code>left &lt;= x &lt;= right</code> 的所有整数 <code>x</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入</strong>
//["CountIntervals", "add", "add", "count", "add", "count"]
//[[], [2, 3], [7, 10], [], [5, 8], []]
//<strong>输出</strong>
//[null, null, null, 6, null, 8]
//
//<strong>解释</strong>
//CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
//countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
//countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
//countIntervals.count();    // 返回 6
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 7、8、9、10 出现在区间 [7, 10] 中
//countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
//countIntervals.count();    // 返回 8
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 5 和 6 出现在区间 [5, 8] 中
//                           // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
//                           // 整数 9 和 10 出现在区间 [7, 10] 中</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= left &lt;= right &lt;= 10<sup>9</sup></code></li>
//	<li>最多调用&nbsp; <code>add</code> 和 <code>count</code> 方法 <strong>总计</strong> <code>10<sup>5</sup></code> 次</li>
//	<li>调用 <code>count</code> 方法至少一次</li>
//</ul>
//<div><li>👍 23</li><li>👎 0</li></div>
package leetcode.editor.cn;

import java.util.Iterator;
import java.util.TreeSet;

// 2276:统计区间中的整数数目
public class CountIntegersInIntervals {

    //leetcode submit region begin(Prohibit modification and deletion)
    class CountIntervals {
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
                if (right < iv.left) {
                    break;
                }
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

    public class Interval implements Comparable<Interval> {
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
/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
