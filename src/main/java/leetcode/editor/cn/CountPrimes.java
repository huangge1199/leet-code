//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 869 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//204:计数质数
public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        // TO TEST
        solution.countPrimes(499979);
    }

    //class Solution {
    //    public int countPrimes(int n) {
    //        if (n <= 2) {
    //            return 0;
    //        }
    //        int count = 1;
    //        for (int i = 3; i < n; i++) {
    //            if (isPrime(i)) {
    //                count++;
    //            }
    //        }
    //        return count;
    //    }

    //    /**
    //     * 判断是否是质数
    //     *
    //     * @param num 数字
    //     * @return true：质数、false：不是质数
    //     */
    //    private boolean isPrime(int num) {
    //        if (num < 2) {
    //            return false;
    //        }
    //        if (num == 2) {
    //            return true;
    //        }
    //        for (int i = 2; i * i <= num; i++) {
    //            if (num % i == 0) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
    //}

    class Solution {
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }
            boolean[] nums = new boolean[n + 1];
            Arrays.fill(nums, true);
            nums[0] = false;
            nums[1] = false;
            int count = 0;
            int max = (int) Math.sqrt(n);
            for (int i = 2; i < n; i++) {
                if (nums[i]) {
                    count++;
                    if (i > max) {
                        continue;
                    }
                    for (int j = i; j * i < n; j++) {
                        nums[j * i] = false;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
