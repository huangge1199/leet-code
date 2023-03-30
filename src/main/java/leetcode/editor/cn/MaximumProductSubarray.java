//<p>给你一个整数数组 <code>nums</code>&nbsp;，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>
//
//<p>测试用例的答案是一个&nbsp;<strong>32-位</strong> 整数。</p>
//
//<p><strong>子数组</strong> 是数组的连续子序列。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [2,3,-2,4]
//<strong>输出:</strong> <span><code>6</code></span>
//<strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> nums = [-2,0,-1]
//<strong>输出:</strong> 0
//<strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li> 
// <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
// <li><code>nums</code> 的任何前缀或后缀的乘积都 <strong>保证</strong>&nbsp;是一个 <strong>32-位</strong> 整数</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1973</li><li>👎 0</li></div>
package leetcode.editor.cn;

// 152:乘积最大子数组
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // TO TEST
        System.out.println(solution.maxProduct(new int[]{2,-5,-2,-4,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int[] arrMax = new int[nums.length];
            int[] arrMin = new int[nums.length];
            arrMax[0] = nums[0];
            arrMin[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                arrMax[i] = Math.max(nums[i],nums[i]*arrMax[i-1]);
                arrMax[i] = Math.max(arrMax[i],nums[i]*arrMin[i-1]);
                max = Math.max(max,arrMax[i]);
                arrMin[i] = Math.min(nums[i],nums[i]*arrMin[i-1]);
                arrMin[i] = Math.min(arrMin[i],nums[i]*arrMax[i-1]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
