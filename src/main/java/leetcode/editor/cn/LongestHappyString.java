//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 109 👎 0

package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//1405:最长快乐字符串
class LongestHappyString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestHappyString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            Queue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
            if (a > 0) {
                queue.add(new int[]{a, 0});
            }
            if (b > 0) {
                queue.add(new int[]{b, 1});
            }
            if (c > 0) {
                queue.add(new int[]{c, 2});
            }
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                int size = sb.length();
                int[] arrs = queue.poll();
                if (size < 2 || sb.charAt(size - 1) - 'a' != arrs[1] || sb.charAt(size - 2) - 'a' != arrs[1]) {
                    sb.append((char) (arrs[1] + 'a'));
                    arrs[0]--;
                    if (arrs[0] != 0) {
                        queue.add(arrs);
                    }
                } else {
                    if (queue.isEmpty()) {
                        break;
                    }
                    int[] arrs1 = queue.poll();
                    sb.append((char) (arrs1[1] + 'a'));
                    arrs1[0]--;
                    if (arrs1[0] != 0) {
                        queue.add(arrs1);
                    }
                    queue.add(arrs);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}