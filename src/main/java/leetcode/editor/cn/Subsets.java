//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1284 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//78:子集
class Subsets{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Subsets().new Solution();
        solution.subsets(new int[]{1,2,3});
    }
    
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = result.get(j);
                result.add(new ArrayList<>(list));
                list.add(nums[i]);
            }
            result.add(new ArrayList<>(Collections.singletonList(nums[i])));
        }
        result.add(new ArrayList<>());
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}