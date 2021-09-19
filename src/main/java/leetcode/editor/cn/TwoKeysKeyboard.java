//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 
// Paste（粘贴）：粘贴 上一次 复制的字符。 
// 
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
//解释：
//最初, 只有一个字符 'A'。
//第 1 步, 使用 Copy All 操作。
//第 2 步, 使用 Paste 操作来获得 'AA'。
//第 3 步, 使用 Paste 操作来获得 'AAA'。
// 
//
// 示例 2： 
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
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 👍 396 👎 0

package leetcode.editor.cn;

//650:只有两个键的键盘
class TwoKeysKeyboard {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TwoKeysKeyboard().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            int[] arrs = new int[n + 1];
            for (int i = 2; i <= n; ++i) {
                arrs[i] = i;
                for (int j = 1; j * j <= i; ++j) {
                    if (i % j == 0) {
                        arrs[i] = Math.min(arrs[i], arrs[j] + i / j);
                        arrs[i] = Math.min(arrs[i], arrs[i / j] + j);
                    }
                }
            }
            return arrs[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}