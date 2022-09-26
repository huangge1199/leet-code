//给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 rig
//ht（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR n
//ums[right] 。 
//
// 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0,3,0], k = 1
//输出：3
//解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
//输出：3
//解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
//输出：3
//解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3] 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 2000 
// 0 <= nums[i] < 210 
// 
// Related Topics 动态规划 
// 👍 57 👎 0

package leetcode.editor.cn;

import java.util.*;

//1787:使所有区间的异或结果为零
public class MakeTheXorOfAllSegmentsEqualToZero {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MakeTheXorOfAllSegmentsEqualToZero().new Solution();
        //3
        System.out.println(solution.minChanges(new int[]{1, 2, 0, 3, 0}, 1));
        //3
        System.out.println(solution.minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3));
        //3
        System.out.println(solution.minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3));
        //11
        System.out.println(solution.minChanges(new int[]{26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11}, 3));
        //11
        System.out.println(solution.minChanges(new int[]{11, 20, 3, 18, 26, 30, 20, 7, 3, 0, 25, 9, 19, 21, 3, 23}, 5));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minChanges(int[] nums, int k) {
            int numCount = 1 << 10;
            List<Map<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list.add(new HashMap<>());
            }
            for (int i = 0; i < nums.length; i++) {
                int index = i % k;
                Map<Integer, Integer> map = list.get(index);
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                list.set(index, map);
            }
            int[] flag = new int[numCount];
            Arrays.fill(flag, Integer.MAX_VALUE / 2);
            flag[0] = 0;
            int length = nums.length % k == 0 ? nums.length / k : nums.length / k + 1;
            for (int i = 0; i < k; i++) {
                Map<Integer, Integer> map = list.get(i);
                int min = Arrays.stream(flag).min().getAsInt();
                int[] temp = new int[numCount];
                Arrays.fill(temp, min);
                for (int j = 0; j < numCount; j++) {
                    for (int key : map.keySet()) {
                        temp[j] = Math.min(temp[j], flag[j ^ key] - map.get(key));
                    }
                    temp[j] += i < nums.length % k || nums.length % k == 0 ? length : length - 1;
                }
                flag = temp;
            }
            return flag[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}