//子字符串 是字符串中的一个连续（非空）的字符序列。 
//
// 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。 
//
// 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aeiouu"
//输出：2
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "aeiouu"
//- "aeiouu"
// 
//
// 示例 2： 
//
// 
//输入：word = "unicornarihan"
//输出：0
//解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
// 
//
// 示例 3： 
//
// 
//输入：word = "cuaieuouac"
//输出：7
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac" 
//
// 示例 4： 
//
// 
//输入：word = "bbaeixoubb"
//输出：0
//解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 仅由小写英文字母组成 
// 
// 👍 0 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//5918:统计字符串中的元音子字符串
class CountVowelSubstringsOfAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CountVowelSubstringsOfAString().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelSubstrings(String word) {
            int sum = 0;
            char[] chs = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                sum += dfs(chs, i, Arrays.asList('a', 'e', 'i', 'o', 'u'), 0, new int[5], 0);
            }
            return sum;
        }

        private int dfs(char[] chs, int index, List<Character> list, int sum, int[] arrs, int count) {
            if (index == chs.length) {
                return sum;
            }
            if (!list.contains(chs[index])) {
                return count == 5 ? sum : 0;
            }
            if (count < 5 && arrs[list.indexOf(chs[index])] == 0) {
                count++;
            }
            arrs[list.indexOf(chs[index])]++;
            if (count == 5) {
                sum += 1;
            }
            return dfs(chs, index + 1, list, sum, arrs, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}