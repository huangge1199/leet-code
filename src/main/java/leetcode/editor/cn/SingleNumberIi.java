//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 
// 👍 565 👎 0

package leetcode.editor.cn;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

//137:只出现一次的数字 II
public class SingleNumberIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SingleNumberIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                map.put(num, map.getOrDefault(num, 0) + 1);
//            }
//            for (int num : map.keySet()) {
//                if (map.get(num) == 1) {
//                    return num;
//                }
//            }
//            return 0;
            int ones = 0, twos = 0;
            for(int num : nums){
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}