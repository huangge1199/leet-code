//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 104 
// -109 <= nums1[i], nums2[i] <= 109 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 
// 👍 199 👎 0

package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

//373:查找和最小的K对数字
class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((v1, v2) ->
                    nums1[v1.getKey()] + nums2[v1.getValue()] - nums1[v2.getKey()] - nums2[v2.getValue()]
            );
            for (int i = 0; i < nums1.length; i++) {
                queue.add(new Pair<>(i, 0));
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                Pair<Integer, Integer> pair = queue.poll();
                result.add(Arrays.asList(nums1[pair.getKey()], nums2[pair.getValue()]));
                if (pair.getValue() + 1 < nums2.length) {
                    queue.add(new Pair<>(pair.getKey(), pair.getValue() + 1));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}