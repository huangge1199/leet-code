//两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。 
//
// 计算一个数组中，任意两个数之间汉明距离的总和。 
//
// 示例: 
//
// 
//输入: 4, 14, 2
//
//输出: 6
//
//解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
//所以答案为：
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 
//2 + 2 = 6.
// 
//
// 注意: 
//
// 
// 数组中元素的范围为从 0到 10^9。 
// 数组的长度不超过 10^4。 
// 
// Related Topics 位运算 
// 👍 154 👎 0

package leetcode.editor.cn;

//477:汉明距离总和
public class TotalHammingDistance {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TotalHammingDistance().new Solution();
        System.out.println(solution.totalHammingDistance(new int[]{4, 14, 2}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int length = nums.length;
            int result = 0;
            int size = 30;
            for (int i = 0; i < size; ++i) {
                int count = 0;
                for (int num : nums) {
                    count += (num >> i) & 1;
                }
                result += count * (length - count);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}