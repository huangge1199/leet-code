//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 0 <= nums[i] <= 231 - 1 
// 
// 
// 
// Related Topics 位运算 字典树 
// 👍 324 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//421:数组中两个数的最大异或值
public class MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
        System.out.println();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int result = 0;
            for (int i = 30; i >= 0; i--) {
                Set<Integer> set = new HashSet<>();
                boolean isHave = false;
                for (int num : nums) {
                    set.add(num >> i);
                    if (set.contains(((result << 1) + 1) ^ (num >> i))) {
                        isHave = true;
                        break;
                    }
                }
                result <<= 1;
                if (isHave) {
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}