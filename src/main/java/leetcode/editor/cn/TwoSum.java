//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11279 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1:两数之和
public class TwoSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TwoSum().new Solution();
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        if (nums.length == 2) {
            result[0] = start;
            result[1] = end;
        } else {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Arrays.sort(nums);
            while (nums[start] + nums[end] != target) {
                if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
            result[0] = list.indexOf(nums[start]);
            list.remove(result[0]);
            result[1] = list.indexOf(nums[end]);
            if (result[1] >= result[0]) {
                result[1]++;
            }
            if (result[0] > result[1]) {
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}