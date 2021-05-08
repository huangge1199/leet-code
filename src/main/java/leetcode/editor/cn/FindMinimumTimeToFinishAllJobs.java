//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。 
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 74 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//1723:完成所有工作的最短时间
public class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
        //3
        System.out.println(solution.minimumTimeRequired(new int[]{3, 2, 3}, 3));
        //11
        System.out.println(solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumTimeRequired(int[] jobs, int k) {
            List<Integer> list = new ArrayList<>();
            return dfs(0, 0, list, 0, Integer.MAX_VALUE, jobs, k);
        }

        int dfs(int index, int kIndex, List<Integer> list, int max, int ans, int[] jobs, int k) {
            if (kIndex < k) {
                list.add(kIndex, jobs[index]);
                if (Math.max(list.get(kIndex), max) < ans) {
                    if (index == jobs.length - 1) {
                        ans = Math.max(list.get(kIndex), max);
                    } else {
                        ans = dfs(index + 1, kIndex + 1, list, Math.max(list.get(kIndex), max), ans, jobs, k);
                    }
                }
                list.add(kIndex, 0);
            }
            for (int i = 0; i < kIndex; i++) {
                list.set(i, list.get(i) + jobs[index]);
                if (Math.max(list.get(i), max) < ans) {
                    if (index == jobs.length - 1) {
                        ans = Math.max(list.get(i), max);
                    } else {
                        ans = dfs(index + 1, kIndex, list, Math.max(list.get(i), max), ans, jobs, k);
                    }
                }
                list.set(i, list.get(i) - jobs[index]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}