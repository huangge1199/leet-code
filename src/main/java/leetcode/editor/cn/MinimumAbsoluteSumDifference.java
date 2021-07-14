//给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。 
//
// 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始
//）。 
//
// 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
//
// 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。 
//
// |x| 定义为： 
//
// 
// 如果 x >= 0 ，值为 x ，或者 
// 如果 x <= 0 ，值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,7,5], nums2 = [2,3,5]
//输出：3
//解释：有两种可能的最优方案：
//- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//输出：0
//解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//输出：20
//解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
//绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 105 
// 1 <= nums1[i], nums2[i] <= 105 
// 
// Related Topics 贪心 数组 二分查找 有序集合 
// 👍 74 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1818:绝对差值和
class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MinimumAbsoluteSumDifference().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            final int MOD = 1000000007;
            //创建 nums1 副本 并排序
            int[] temp = Arrays.copyOf(nums1, nums1.length);
            Arrays.sort(temp);
            //求解 minDif 数组
            int len = nums1.length;
            int[] minDif = new int[len];
            for (int i = 0; i < len; i++) {
                int[] arr = leftright(temp, nums2[i]);
                if (nums2[i] - temp[arr[0]] < temp[arr[1]] - nums2[i])
                    minDif[i] = temp[arr[0]];
                else
                    minDif[i] = temp[arr[1]];
            }
            //寻找合适的元素，替换nums1中的元素
            int index = 0;
            int max = 0;
            for (int i = 0; i < len; i++) {
                int dif = Math.abs(nums1[i] - nums2[i]) - Math.abs(minDif[i] - nums2[i]);
                if (dif > max) {
                    index = i;
                    max = dif;
                }
            }
            nums1[index] = minDif[index];
            //累加和
            int sum = 0;
            for (int i = 0; i < len; i++)
                sum = (sum + Math.abs(nums1[i] - nums2[i])) % MOD;
            return sum;
        }

        //二分查找
        public int[] leftright(int[] arr, int value) {
            int left = 0;
            int right = arr.length - 1;
            int[] result = new int[2];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == value) {
                    result[0] = result[1] = mid;
                    return result;
                } else if (arr[mid] < value)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            result[0] = left > 0 ? left - 1 : 0;
            result[1] = right < arr.length - 1 ? right + 1 : arr.length - 1;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}