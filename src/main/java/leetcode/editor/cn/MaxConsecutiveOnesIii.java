//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 316 👎 0

package leetcode.editor.cn;

//1004:最大连续1的个数 III
class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        solution.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int index = 0, lsum = 0, rsum = 0;
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                rsum += 1 - nums[i];
                while (lsum < rsum - k) {
                    lsum += 1 - nums[index];
                    index++;
                }
                count = Math.max(count, i - index + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}