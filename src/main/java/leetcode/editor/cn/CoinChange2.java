//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 456 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//518:零钱兑换 II
public class CoinChange2 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CoinChange2().new Solution();
        System.out.println(solution.change(5,new int[]{1,2,5}));
        System.out.println(solution.change(3,new int[]{2}));
        System.out.println(solution.change(10,new int[]{10}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] map = new int[coins.length][amount + 1];
            for (int[] ints : map) {
                Arrays.fill(ints, -1);
            }
            return dfs(coins, 0, amount, map);
        }

        int dfs(int[] coins, int i, int amount, int[][] map) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0 || i == coins.length) {
                return 0;
            }
            if (map[i][amount] != -1) {
                return map[i][amount];
            }
            int res = 0;
            res += dfs(coins, i + 1, amount, map);
            res += dfs(coins, i, amount - coins[i], map);
            return map[i][amount] = res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}