//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 300 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//525:连续数组
public class ContiguousArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ContiguousArray().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int max = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int count = 0;
            map.put(count, -1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count++;
                } else {
                    count--;
                }
                if (map.containsKey(count)) {
                    max = Math.max(max, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}