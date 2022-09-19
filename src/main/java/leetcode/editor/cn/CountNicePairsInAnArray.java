//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， r
//ev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 
// Related Topics 数组 哈希表 
// 👍 13 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//1814:统计一个数组中好对子的数目
public class CountNicePairsInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CountNicePairsInAnArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNicePairs(int[] nums) {
            Map<Integer, Long> map = new HashMap<>();
            for (int num : nums) {
                int key = num - revert(num);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, Long.parseLong("1"));
                }
            }
            long count = 0;
            for (int key : map.keySet()) {
                long value = map.get(key);
                if (value > 1) {
                    count += value * (value - 1) / 2;
                }
            }
            return (int) (count % (Math.pow(10, 9) + 7));
        }

        private int revert(int num) {
            String str = "" + num;
            str = new StringBuilder(str).reverse().toString();
            return Integer.parseInt(str);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}