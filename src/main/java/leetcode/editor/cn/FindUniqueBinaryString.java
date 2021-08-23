//给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 
//nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = ["01","10"]
//输出："11"
//解释："11" 没有出现在 nums 中。"00" 也是正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = ["00","01"]
//输出："11"
//解释："11" 没有出现在 nums 中。"10" 也是正确答案。
// 
//
// 示例 3： 
//
// 
//输入：nums = ["111","011","001"]
//输出："101"
//解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 16 
// nums[i].length == n 
// nums[i] 为 '0' 或 '1' 
// 
// 👍 2 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//1980:找出不同的二进制字符串
class FindUniqueBinaryString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FindUniqueBinaryString().new Solution();
    }
    
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        List<String> list = Arrays.asList(nums);
        int max = (int) Math.pow(2, n);
        for (int i = max - 1; i >= 0; i--) {
            if (!list.contains(Integer.toBinaryString(i))) {
                String temp = Integer.toBinaryString(i);
                while (temp.length() < n) {
                    temp = "0" + temp;
                }
                return temp;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}