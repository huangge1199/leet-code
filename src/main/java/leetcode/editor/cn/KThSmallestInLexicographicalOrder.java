//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 389 👎 0

package leetcode.editor.cn;

//440:字典序的第K小数字
public class KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();
        // TO TEST
        System.out.println(solution.findKthNumber(13, 2));
        System.out.println(solution.findKthNumber(1, 1));
        System.out.println(solution.findKthNumber(100, 90));
        System.out.println(solution.findKthNumber(10000, 10000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            for (int i = 1; i <= n; i++) {
                if (k == 1) {
                    return i;
                }
                int count = getCount(i, n);
                if (count < k) {
                    k -= count;
                } else {
                    i = i * 10 - 1;
                    k--;
                }
            }
            return 0;
        }

        public int getCount(int num, long n) {
            int count = 0;
            long min = num;
            long max = num;
            while (min <= n) {
                count += Math.min(max, n) - min + 1;
                min = min * 10;
                max = max * 10 + 9;
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
