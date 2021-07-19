//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1756 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//70:爬楼梯
public class ClimbingStairs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ClimbingStairs().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> map = new HashMap<>();

        public int climbStairs(int n) {
            if (map.containsKey(n)) {
                return map.get(n);
            }
            if (n == 0) {
                map.put(0, 1);
                return 1;
            }
            if (n < 0) {
                map.put(-1, 0);
                return 0;
            }
            int count = 0;
            count += climbStairs(n - 1);
            count += climbStairs(n - 2);
            map.put(n, count);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}