//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1450 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//46:全排列
public class Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Permutations().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> list;

        public List<List<Integer>> permute(int[] nums) {
            list = new ArrayList<>();
            dfs(nums, new ArrayList<>());
            return list;
        }

        private void dfs(int[] nums, List<Integer> temp) {
            if (temp.size() == nums.length) {
                list.add(new ArrayList<>(temp));
                return;
            }
            for (int num : nums) {
                if (!temp.contains(num)) {
                    temp.add(num);
                    dfs(nums, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}