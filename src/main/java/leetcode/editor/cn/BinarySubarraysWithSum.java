//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 157 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//930:和相同的二元子数组
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinarySubarraysWithSum().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
////            执行耗时:21 ms,击败了60.31% 的Java用户
////            内存消耗:43.1 MB,击败了11.31% 的Java用户
//            int sum = 0, count = 0;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                map.put(sum, map.getOrDefault(sum, 0) + 1);
//                sum += num;
//                count += map.getOrDefault(sum - goal, 0);
//            }
//            return count;

////            执行耗时:2 ms,击败了98.67% 的Java用户
////            内存消耗:41.7 MB,击败了76.94% 的Java用户
            int sum = 0, count = 0;
            int[] sums = new int[nums.length + 1];
            for (int num : nums) {
                sums[sum]++;
                sum += num;
                count += sum - goal >= 0 ? sums[sum - goal] : 0;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}