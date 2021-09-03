//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 
//
// 示例： 
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。 
// Related Topics 数组 哈希表 字符串 👍 57 👎 0

package leetcode.editor.cn;

import java.util.*;

//249:移位字符串分组
class GroupShiftedStrings {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GroupShiftedStrings().new Solution();
        solution.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strings) {
                int sub = s.charAt(0) - 'a';
                if (sub == 0) {
                    List<String> list = map.getOrDefault(s, new ArrayList<>());
                    list.add(s);
                    map.put(s, new ArrayList<>(list));
                    continue;
                }
                char[] chs = s.toCharArray();
                chs[0] = 'a';
                for (int i = 1; i < chs.length; i++) {
                    chs[i] -= sub;
                    if (chs[i] < 'a') {
                        chs[i] += 26;
                    }
                }
                String key = String.valueOf(chs);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s);
                map.put(key, new ArrayList<>(list));
            }
            List<List<String>> result = new ArrayList<>();
            for (String key : map.keySet()) {
                result.add(new ArrayList<>(map.get(key)));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}