//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 626 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//77:组合
public class Combinations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new Combinations().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> list = new ArrayList<>();

        //        public List<List<Integer>> combine(int n, int k) {
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = i + 1;
//            }
//            dfs(nums, new ArrayList<>(), k);
//            return list;
//        }
//
//        private void dfs(int[] nums, List<Integer> temp, int k) {
//            if (k == temp.size()) {
//                list.add(new ArrayList<>(temp));
//                return;
//            }
//
//            for (int num : nums) {
//                if (temp.size() == 0 || num > temp.get(temp.size() - 1)) {
//                    temp.add(num);
//                    dfs(nums, temp, k);
//                    temp.remove(temp.size() - 1);
//                }
//            }
//        }
        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1, new ArrayList<>());
            return list;
        }

        public void dfs(int n, int k, int cur, List<Integer> list) {
            if (k == 0) {
                this.list.add(new ArrayList<>(list));
                return;
            }
            for (int i = cur; i <= n - k + 1; i++) {
                list.add(i);
                dfs(n, k - 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}