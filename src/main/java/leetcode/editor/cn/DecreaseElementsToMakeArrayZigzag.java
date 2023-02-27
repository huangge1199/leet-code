//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。 
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组： 
//
// 
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ... 
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
// 
//
// 示例 2： 
//
// 输入：nums = [9,6,1,6,2]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 
// 👍 33 👎 0

package leetcode.editor.cn;

//1144:递减元素使数组呈锯齿状
class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new DecreaseElementsToMakeArrayZigzag().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int[] s = new int[2];
            for (int i = 0, n = nums.length; i < n; ++i) {
                int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
                int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
                s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
            }
            return Math.min(s[0], s[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}