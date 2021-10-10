//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 255 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//187:重复的DNA序列
class RepeatedDnaSequences {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RepeatedDnaSequences().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> cnt = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; ++i) {
                String sub = s.substring(i, i + 10);
                cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
                if (cnt.get(sub) == 2) {
                    result.add(sub);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}