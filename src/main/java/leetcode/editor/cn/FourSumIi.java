//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2²⁸ 到 2²⁸ - 1 之间，最
//终结果不会超过 2³¹ - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 数组 哈希表 👍 408 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//454:四数相加 II
class FourSumIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FourSumIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            int size = nums1.length;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map1.put(nums1[i] + nums2[j], map1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                    map2.put(nums3[i] + nums4[j], map2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
                }
            }
            int count = 0;
            for (int key : map1.keySet()) {
                if (map2.containsKey(-key)) {
                    count += map1.get(key) * map2.get(-key);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}