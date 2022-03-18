//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics 数组 👍 78 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//163:缺失的区间
public class MissingRanges {
    public static void main(String[] args) {
        Solution solution = new MissingRanges().new Solution();
        solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            int index = 0;
            List<String> list = new ArrayList<>();
            for (int i = lower; i <= upper; i++) {
                while (index < nums.length && nums[index] < i) {
                    index++;
                }
                if (index == nums.length) {
                    if (i == upper) {
                        list.add("" + i);
                    } else {
                        list.add(i + "->" + upper);
                    }
                    break;
                }
                if (nums[index] > i) {
                    if (nums[index] == i + 1) {
                        list.add("" + i);
                    } else {
                        list.add(i + "->" + (nums[index] - 1));
                    }
                    i = nums[index];
                    index++;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}