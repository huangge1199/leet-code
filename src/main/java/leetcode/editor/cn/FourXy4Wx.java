//小力将 N 个零件的报价存于数组 `nums`。小力预算为 `target`，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
//
//
//注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
//
//
//**示例 1：**
//>输入：`nums = [2,5,3,5], target = 6`
//>
//>输出：`1`
//>
//>解释：预算内仅能购买 nums[0] 与 nums[2]。
//
//**示例 2：**
//>输入：`nums = [2,2,1,9], target = 10`
//>
//>输出：`4`
//>
//>解释：符合预算的采购方案如下：
//>nums[0] + nums[1] = 4
//>nums[0] + nums[2] = 3
//>nums[1] + nums[2] = 3
//>nums[2] + nums[3] = 10
//
//**提示：**
//- `2 <= nums.length <= 10^5`
//- `1 <= nums[i], target <= 10^5`
// 👍 25 👎 0

package leetcode.editor.cn;

//LCP 28:采购方案
public class FourXy4Wx {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FourXy4Wx().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            int[] sort = new int[target];
            long[] count = new long[target];
            for (int num : nums) {
                if (num < target) {
                    sort[num] += 1;
                }
            }
            long sum = 0;
            for (int i = 1; i < target; i++) {
                sum += sort[i];
                count[i] = sum;
            }
            long result = 0;
            for (int num : nums) {
                if (target > num) {
                    result += num <= target - num ? count[target - num] - 1 : count[target - num];
                }
            }
            return (int) (result / 2 % (Math.pow(10, 9) + 7));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}