//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 👍 836 👎 0

package leetcode.editor.cn;

import java.util.*;

//49:字母异位词分组
class GroupAnagrams {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chs = s.toCharArray();
                Arrays.sort(chs);
                String str = Arrays.toString(chs);
                List<String> list = map.getOrDefault(str, new ArrayList<>());
                list.add(s);
                map.put(str, new ArrayList<>(list));
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