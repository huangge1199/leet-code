//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 976 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18:四数之和
class FourSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FourSum().new Solution();
//        solution.fourSum(new int[]{1,0,-1,0,-2,2},0);
        solution.fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 4) {
                return result;
            }
            Arrays.sort(nums);
            int length = nums.length;
            long sum;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                sum = (long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
                if (sum > target) {
                    break;
                }
                sum = (long)nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1];
                if (sum < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    sum = (long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                    if (sum > target) {
                        break;
                    }
                    sum = (long)nums[i] + nums[j] + nums[length - 2] + nums[length - 1];
                    if (sum < target) {
                        continue;
                    }
                    int start = j + 1;
                    int end = length - 1;
                    while (start < end) {
                        sum = (long)nums[i] + nums[j] + nums[start] + nums[end];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                            while (start < end && nums[start] == nums[start + 1]) {
                                start++;
                            }
                            start++;
                            while (start < end && nums[end] == nums[end - 1]) {
                                end--;
                            }
                            end--;
                        } else if (sum < target) {
                            start++;
                        } else {
                            end--;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}