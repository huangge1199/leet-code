//编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
//
// 注意：本题相对原题稍作修改 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 66 👎 0

package leetcode.editor.cn;

import java.util.*;

//面试题 10.02:变位词组
class GroupAnagramsLcci {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new GroupAnagramsLcci().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                List<String> list = map.getOrDefault(new String(chars), new ArrayList<>());
                list.add(str);
                map.put(new String(chars), list);
            }
            List<List<String>> result = new ArrayList<>();
            for (String key : map.keySet()) {
                result.add(map.get(key));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}