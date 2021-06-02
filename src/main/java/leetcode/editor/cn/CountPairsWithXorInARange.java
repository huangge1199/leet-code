//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 2 * 104 
// 1 <= low <= high <= 2 * 104 
// 
// Related Topics 字典树 
// 👍 40 👎 0

package leetcode.editor.cn;

//1803:统计异或值在范围内的数对有多少
public class CountPairsWithXorInARange {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CountPairsWithXorInARange().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            // xors[index] ： nums[0]^数组中其他值=index
            int[] xors = new int[32768];
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                int num = nums[0] ^ nums[i];
                if (num >= low && num <= high) {
                    count++;
                }
                xors[num]++;
            }
            // xor ^ j = index = nums[0] ^ 数组中其他值
            // xor ^ j = nums[0] ^ 数组中其他值
            // xor ^ j ^ (nums[0] ^ 数组中其他值 ^ j) = nums[0] ^ 数组中其他值 ^ (nums[0] ^ 数组中其他值 ^ j)
            // nums[i] ^ 数组中其他值 = j
            for (int i = 1; i < nums.length; i++) {
                int xor = nums[0] ^ nums[i];
                xors[xor]--;
                for (int j = low; j <= high; j++) {
                    int index = xor ^ j;
                    count += xors[index];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}