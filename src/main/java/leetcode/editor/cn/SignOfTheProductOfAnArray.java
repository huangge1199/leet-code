//<p>已知函数 <code>signFunc(x)</code> 将会根据 <code>x</code> 的正负返回特定值：</p>
//
//<ul>
//	<li>如果 <code>x</code> 是正数，返回 <code>1</code> 。</li>
//	<li>如果 <code>x</code> 是负数，返回 <code>-1</code> 。</li>
//	<li>如果 <code>x</code> 是等于 <code>0</code> ，返回 <code>0</code> 。</li>
//</ul>
//
//<p>给你一个整数数组 <code>nums</code> 。令 <code>product</code> 为数组 <code>nums</code> 中所有元素值的乘积。</p>
//
//<p>返回 <code>signFunc(product)</code> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,-2,-3,-4,3,2,1]
//<strong>输出：</strong>1
//<strong>解释：</strong>数组中所有值的乘积是 144 ，且 signFunc(144) = 1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,5,0,2,-3]
//<strong>输出：</strong>0
//<strong>解释：</strong>数组中所有值的乘积是 0 ，且 signFunc(0) = 0
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,1,-1,1,-1]
//<strong>输出：</strong>-1
//<strong>解释：</strong>数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= nums.length <= 1000</code></li>
//	<li><code>-100 <= nums[i] <= 100</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 20</li><li>👎 0</li></div>
package leetcode.editor.cn;

/**
 * Classname ${NAME}
 * Description 1822:数组元素积的符号
 * Date ${DATE} ${TIME}
 * author ${USER}
 */
public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        Solution solution = new SignOfTheProductOfAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arraySign(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    count++;
                } else if (nums[i] == 0) {
                    return 0;
                }
            }
            return count % 2 == 0 ? 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
