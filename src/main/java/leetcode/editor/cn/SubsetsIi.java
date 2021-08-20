//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 630 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90:子集 II
class SubsetsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SubsetsIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            dfs(nums,0,new ArrayList<>(),result,new ArrayList<>());
            return result;
        }

        private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> result, List<String> use) {
            if (index == nums.length) {
                List<Integer> temp = new ArrayList<>(list);
                String key = Arrays.toString(temp.toArray());
                if (!use.contains(key)) {
                    result.add(temp);
                    use.add(key);
                }
                return;
            }
            list.add(nums[index]);
            dfs(nums, index + 1, list, result, use);
            list.remove(list.size() - 1);
            dfs(nums, index + 1, list, result, use);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}