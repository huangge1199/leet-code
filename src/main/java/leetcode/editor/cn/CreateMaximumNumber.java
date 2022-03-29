//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 栈 贪心 单调栈 👍 458 👎 0

package leetcode.editor.cn;

//321:拼接最大数
public class CreateMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new CreateMaximumNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] res = new int[0];
            // 从 nums1 中选出长 i 的子序列
            for (int i = 0; i <= k && i <= nums1.length; i++) {
                // 从 nums2 中选出长 k - i 的子序列
                if (k - i >= 0 && k - i <= nums2.length) {
                    // 合并
                    int[] tmp = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, k - i));
                    // 取最大值
                    if (compare(tmp, 0, res, 0)) {
                        res = tmp;
                    }
                }
            }
            return res;
        }

        // 类似于单调递减栈
        public int[] subMaxNumber(int[] nums, int len) {
            int[] subNums = new int[len];
            int cur = 0, rem = nums.length - len; // rem 表示还可以删去多少字符
            for (int i = 0; i < nums.length; i++) {
                while (cur > 0 && subNums[cur - 1] < nums[i] && rem > 0) {
                    cur--;
                    rem--;
                }
                if (cur < len) {
                    subNums[cur++] = nums[i];
                } else {
                    rem--; // 避免超过边界而少删字符
                }
            }
            return subNums;
        }

        public int[] merge(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length + nums2.length];
            int cur = 0, p1 = 0, p2 = 0;
            while (cur < nums1.length + nums2.length) {
                if (compare(nums1, p1, nums2, p2)) { // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
                    res[cur++] = nums1[p1++];
                } else {
                    res[cur++] = nums2[p2++];
                }
            }
            return res;
        }

        public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
            if (p2 >= nums2.length) return true;
            if (p1 >= nums1.length) return false;
            if (nums1[p1] > nums2[p2]) return true;
            if (nums1[p1] < nums2[p2]) return false;
            return compare(nums1, p1 + 1, nums2, p2 + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}